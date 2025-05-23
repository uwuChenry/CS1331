import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.util.Duration;
import java.util.List;

import java.util.ArrayList;
import java.io.File;

import javafx.scene.media.Media;

/**
 * JungeonJrawler is a simple dungeon crawler game get to the exit while avoiding enemies to win.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class JungeonJrawler extends Application {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Jungeon Jrawler";

    /**
     * The main entry point for the application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }

    private MediaPlayer welcomeMusic;
    private MediaPlayer gameMusic;
    private MediaPlayer gameOverMusic;

    /**
     * Initializes the application by setting the window title and showing
     * the welcome screen.
     *
     * @param primaryStage The primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(WINDOW_TITLE);

        showWelcomeScreen(primaryStage);
        primaryStage.show();
    }

    /**
     * Displays the welcome screen with a title, play button, and background image.
     * Starts playing background music for the welcome screen.
     *
     * @param primaryStage The primary stage for this application
     */
    private void showWelcomeScreen(Stage primaryStage) {

        if (gameOverMusic != null) {
            gameOverMusic.stop();
        }
        try {
            String musicFile = "src/welcome.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            welcomeMusic = new MediaPlayer(sound);
            welcomeMusic.setCycleCount(MediaPlayer.INDEFINITE);
            welcomeMusic.setVolume(0.2);
            welcomeMusic.play();
        } catch (Exception ex) {
            System.out.println("Could not play welcome music: " + ex.getMessage());
        }

        VBox welcomeLayout = new VBox(30);
        welcomeLayout.setAlignment(Pos.TOP_CENTER);
        welcomeLayout.setPadding(new Insets(100, 10, 10, 10));

        Text titleText = new Text("DungeonFX");
        titleText.setFont(Font.font(null, FontPosture.ITALIC, 48));
        titleText.setFill(Color.WHITE);

        Button playButton = new Button("Play");
        playButton.setFont(Font.font(18));
        playButton.setPrefWidth(100);
        playButton.setOnAction(e -> showCharacterNamingScreen(primaryStage));

        welcomeLayout.getChildren().addAll(titleText, playButton);

        try {
            Image backgroundImage = new Image("welcomeImage.png");
            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, true, true));
            welcomeLayout.setBackground(new Background(background));
        } catch (Exception e) {
            System.out.println("Could not load welcome screen image. Using fallback background.");
            welcomeLayout.setStyle("-fx-background-color: #2a3b4c;");
        }

        Scene welcomeScene = new Scene(welcomeLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(welcomeScene);
    }

    /**
     * Displays the character naming screen where the player can enter their name.
     * Validates that the player has entered a name before proceeding to the game screen.
     *
     * @param primaryStage The primary stage for this application
     */
    private void showCharacterNamingScreen(Stage primaryStage) {
        VBox namingLayout = new VBox(30);
        namingLayout.setAlignment(Pos.CENTER_RIGHT);
        namingLayout.setPadding(new Insets(100, 90, 10, 10));

        Text whoAmIText = new Text("Who am I?");
        whoAmIText.setFont(Font.font(32));
        whoAmIText.setFill(Color.WHITE);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter name here...");
        nameField.setMaxWidth(300);
        nameField.setFont(Font.font(16));
        nameField.setText("");
        nameField.setStyle("-fx-prompt-text-fill: #A9A9A9;");

        Button beginButton = new Button("Begin Jrawl");
        beginButton.setFont(Font.font(18));
        beginButton.setPrefWidth(150);
        beginButton.setOnAction(e -> {
            String playerName = nameField.getText().trim();
            if (playerName.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Name Entered");
                alert.setHeaderText(null);
                alert.setContentText("Please enter your name before beginning.");
                alert.showAndWait();
            } else {
                showGameScreen(primaryStage, playerName);
            }
        });

        namingLayout.getChildren().addAll(whoAmIText, nameField, beginButton);

        try {
            Image backgroundImage = new Image("characterImage.png");
            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100, 100, true, true, true, true));
            namingLayout.setBackground(new Background(background));
        } catch (Exception e) {
            System.out.println("Could not load character screen image. Using fallback background.");
            namingLayout.setStyle("-fx-background-color: #3a2b5c;");
        }

        Scene namingScene = new Scene(namingLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(namingScene);
    }

    /**
     * Displays the main game screen where the player navigates a maze to reach the exit.
     * Sets up the game environment including the player, enemies, maze walls, and goal.
     * Handles player input, collision detection, and game state updates.
     *
     * @param primaryStage The primary stage for this application
     * @param playerName The name entered by the player on the character naming screen
     */
    private void showGameScreen(Stage primaryStage, String playerName) {
        if (welcomeMusic != null) {
            welcomeMusic.stop();
        }

        try {
            String musicFile = "src/fight.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            gameMusic = new MediaPlayer(sound);
            gameMusic.setCycleCount(MediaPlayer.INDEFINITE);
            gameMusic.play();
        } catch (Exception ex) {
            System.out.println("Could not play game music: " + ex.getMessage());
        }

        Pane gameLayout = new Pane();
        gameLayout.setStyle("-fx-background-color: black;");

        Rectangle playerRect = new Rectangle(550, 550, 20, 20);
        playerRect.setFill(Color.BLUE);

        Text playerNameText = new Text(playerName);
        playerNameText.setFill(Color.WHITE);
        playerNameText.setFont(Font.font(12));

        // Set up enemy objects
        ImageView enemy1Rect = new ImageView(new Image("monster.png"));
        enemy1Rect.setX(400);
        enemy1Rect.setY(200);
        enemy1Rect.setFitWidth(30);
        enemy1Rect.setFitHeight(30);
        enemy1Rect.setPreserveRatio(false);

        ImageView enemy2Rect = new ImageView(new Image("monster.png"));
        enemy2Rect.setX(500);
        enemy2Rect.setY(300);
        enemy2Rect.setFitWidth(30);
        enemy2Rect.setFitHeight(30);
        enemy2Rect.setPreserveRatio(false);

        Rectangle enemy1HitBox = new Rectangle(400, 200, 30, 30);
        enemy1HitBox.setOpacity(0);

        Rectangle enemy2HitBox = new Rectangle(500, 300, 30, 30);
        enemy2HitBox.setOpacity(0);

        String enemy1Name = Backend.generateRandomName();
        String enemy2Name = Backend.generateRandomName();

        Text enemy1NameText = new Text(enemy1Name);
        enemy1NameText.setFill(Color.WHITE);
        enemy1NameText.setFont(Font.font(12));

        Text enemy2NameText = new Text(enemy2Name);
        enemy2NameText.setFill(Color.WHITE);
        enemy2NameText.setFont(Font.font(12));

        Rectangle goalRect = new Rectangle(660, 110, 90, 30);
        goalRect.setFill(Color.GREEN);

        List<Rectangle> walls = Backend.buildMaze(Color.GRAY);

        Backend backend = new Backend(walls, goalRect, playerRect, enemy1HitBox, enemy2HitBox);

        int playerLives = 5;
        List<Rectangle> healthBars = new ArrayList<>();
        for (int i = 0; i < playerLives; i++) {
            Rectangle healthBar = new Rectangle(10 + (i * 25), 10, 20, 10);
            healthBar.setFill(Color.GREEN);
            healthBars.add(healthBar);
        }

        Text healthText = new Text("Health Bar");
        healthText.setFill(Color.WHITE);
        healthText.setX(10);
        healthText.setY(35);

        Button instructionsButton = new Button("Instructions");
        instructionsButton.setLayoutX(WINDOW_WIDTH - 100);
        instructionsButton.setLayoutY(10);
        instructionsButton.setOnAction(e -> showInstructions());

        gameLayout.getChildren().addAll(walls);
        gameLayout.getChildren().add(goalRect);
        gameLayout.getChildren().addAll(playerRect, playerNameText);
        gameLayout.getChildren().addAll(enemy1Rect, enemy1NameText,
            enemy2Rect, enemy2NameText, enemy1HitBox, enemy2HitBox);
        gameLayout.getChildren().addAll(healthBars);
        gameLayout.getChildren().add(healthText);
        gameLayout.getChildren().add(instructionsButton);

        Scene gameScene = new Scene(gameLayout, WINDOW_WIDTH, WINDOW_HEIGHT);


        boolean[] upPressed = {false};
        boolean[] downPressed = {false};
        boolean[] leftPressed = {false};
        boolean[] rightPressed = {false};

        setupKeyHandling(gameScene, upPressed, downPressed, leftPressed, rightPressed);

        final boolean[] isInvulnerable = {false};

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateTextPositions(playerRect, playerNameText, enemy1Rect, enemy1NameText,
                                  enemy2Rect, enemy2NameText);

                handlePlayerMovement(backend, playerRect, upPressed, downPressed, leftPressed, rightPressed);

                handleEnemyMovement(backend, enemy1Rect, enemy1HitBox, enemy2Rect, enemy2HitBox, isInvulnerable);

                if (!isInvulnerable[0] && backend.enemyCollision(playerRect.getX(), playerRect.getY())) {
                    handlePlayerCollision(primaryStage, this, healthBars, gameLayout, playerRect, isInvulnerable);
                }

                if (backend.goalReached()) {
                    handleGoalReached(primaryStage, this);
                }
            }
        };

        primaryStage.setScene(gameScene);
        gameLoop.start();
    }

    private void setupKeyHandling(Scene gameScene, boolean[] upPressed, boolean[] downPressed,
                                boolean[] leftPressed, boolean[] rightPressed) {
        gameScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                upPressed[0] = true;
            } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                downPressed[0] = true;
            } else if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                leftPressed[0] = true;
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                rightPressed[0] = true;
            }
        });

        gameScene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {
                upPressed[0] = false;
            } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {
                downPressed[0] = false;
            } else if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {
                leftPressed[0] = false;
            } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {
                rightPressed[0] = false;
            }
        });
    }

    private void updateTextPositions(Rectangle playerRect, Text playerNameText,
                                   ImageView enemy1Rect, Text enemy1NameText,
                                   ImageView enemy2Rect, Text enemy2NameText) {
        playerNameText.setX(playerRect.getX());
        playerNameText.setY(playerRect.getY() - 5);

        enemy1NameText.setX(enemy1Rect.getX());
        enemy1NameText.setY(enemy1Rect.getY() - 5);

        enemy2NameText.setX(enemy2Rect.getX());
        enemy2NameText.setY(enemy2Rect.getY() - 5);
    }

    private void handlePlayerMovement(Backend backend, Rectangle playerRect,
                                    boolean[] upPressed, boolean[] downPressed,
                                    boolean[] leftPressed, boolean[] rightPressed) {
        double newX = playerRect.getX();
        double newY = playerRect.getY();
        double moveSpeed = 2;

        if (upPressed[0] && !downPressed[0]) {
            newY -= moveSpeed;
        }
        if (downPressed[0] && !upPressed[0]) {
            newY += moveSpeed;
        }
        if (leftPressed[0] && !rightPressed[0]) {
            newX -= moveSpeed;
        }
        if (rightPressed[0] && !leftPressed[0]) {
            newX += moveSpeed;
        }

        if (!backend.wallCollision(newX, newY)) {
            playerRect.setX(newX);
            playerRect.setY(newY);
        } else {
            if (newX != playerRect.getX() && newY != playerRect.getY()) {
                if (!backend.wallCollision(newX, playerRect.getY())) {
                    playerRect.setX(newX);
                } else if (!backend.wallCollision(playerRect.getX(), newY)) {
                    playerRect.setY(newY);
                }
            }
        }
    }

    private void handleEnemyMovement(Backend backend, ImageView enemy1Rect, Rectangle enemy1HitBox,
                                   ImageView enemy2Rect, Rectangle enemy2HitBox,
                                   boolean[] isInvulnerable) {
        if (!isInvulnerable[0]) {
            double[] enemy1Pos = backend.enemy1ChasePlayer();
            if (!backend.wallCollision(enemy1Pos[0], enemy1Pos[1])) {
                enemy1Rect.setX(enemy1Pos[0]);
                enemy1Rect.setY(enemy1Pos[1]);
                enemy1HitBox.setX(enemy1Pos[0]); // Update the hitbox
                enemy1HitBox.setY(enemy1Pos[1]);
            }

            double[] enemy2Pos = backend.enemy2ChasePlayer();
            if (!backend.wallCollision(enemy2Pos[0], enemy2Pos[1])) {
                enemy2Rect.setX(enemy2Pos[0]);
                enemy2Rect.setY(enemy2Pos[1]);
                enemy2HitBox.setX(enemy2Pos[0]); // Update the hitbox
                enemy2HitBox.setY(enemy2Pos[1]);
            }
        }
    }

    private void handlePlayerCollision(Stage primaryStage, AnimationTimer gameLoop,
                                     List<Rectangle> healthBars, Pane gameLayout,
                                     Rectangle playerRect, boolean[] isInvulnerable) {
        if (!healthBars.isEmpty()) {
            Rectangle healthBar = healthBars.remove(healthBars.size() - 1);
            gameLayout.getChildren().remove(healthBar);

            System.out.println("sound played");
            try {
                String soundFile = "src/hurt.wav";
                Media sound = new Media(new File(soundFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            } catch (Exception ex) {
                System.out.println("Could not play hurt sound: " + ex.getMessage());
            }

            isInvulnerable[0] = true;
            playerRect.setOpacity(0.5);

            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(event -> {
                isInvulnerable[0] = false;
                playerRect.setOpacity(1.0);
            });
            pause.play();
        }

        if (healthBars.isEmpty()) {
            gameLoop.stop();
            if (gameMusic != null) {
                gameMusic.stop();
            }
            System.out.println("You lost!");
            try {
                String soundFile = "src/lose.wav";
                Media sound = new Media(new File(soundFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                mediaPlayer.setVolume(0.1);
            } catch (Exception ex) {
                System.out.println("Could not play lose sound: " + ex.getMessage());
            }
            showGameOverScreen(primaryStage, false);
        }
    }

    private void handleGoalReached(Stage primaryStage, AnimationTimer gameLoop) {
        if (gameMusic != null) {
            gameMusic.stop();
        }
        try {
            String soundFile = "src/win.wav";
            Media sound = new Media(new File(soundFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            mediaPlayer.setVolume(0.1);
        } catch (Exception ex) {
            System.out.println("Could not play win sound: " + ex.getMessage());
        }
        gameLoop.stop();
        System.out.println("Congrats you won!");
        showGameOverScreen(primaryStage, true);
    }

    private void showInstructions() {
        Stage instructionsStage = new Stage();
        instructionsStage.initModality(Modality.APPLICATION_MODAL);
        instructionsStage.setTitle("Game Instructions");

        VBox instructionsLayout = new VBox(20);
        instructionsLayout.setPadding(new Insets(20));
        instructionsLayout.setAlignment(Pos.CENTER);

        Text titleText = new Text("DungeonFX Instructions");
        titleText.setFont(Font.font(18));

        Text movementText = new Text(
                "- Use WASD or arrow keys to move the player\n"
                    + "- Avoid the enemies\n"
                    + "- Reach the green exit to win\n"
                    + "- You have 5 lives\n"
                    + "- After being hit, you're invulnerable for 0.5 seconds");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> instructionsStage.close());

        instructionsLayout.getChildren().addAll(titleText, movementText, closeButton);

        Scene instructionsScene = new Scene(instructionsLayout, 400, 300);
        instructionsStage.setScene(instructionsScene);
        instructionsStage.show();
    }

    /**
     * Displays the game over screen when the player either wins or loses.
     * Provides a button to play again.
     *
     * @param primaryStage The primary stage for this application
     * @param hasWon Boolean indicating whether the player won (true) or lost (false)
     */
    private void showGameOverScreen(Stage primaryStage, boolean hasWon) {
        VBox gameOverLayout = new VBox(20);
        gameOverLayout.setAlignment(Pos.CENTER);
        gameOverLayout.setPadding(new Insets(20));

        try {
            String musicFile = "src/reward.wav";
            Media sound = new Media(new File(musicFile).toURI().toString());
            gameOverMusic = new MediaPlayer(sound);
            gameOverMusic.setCycleCount(MediaPlayer.INDEFINITE);
            gameOverMusic.setVolume(0.2);
            gameOverMusic.play();
        } catch (Exception ex) {
            System.out.println("Could not play game over music: " + ex.getMessage());
        }

        Text resultText;
        if (hasWon) {
            resultText = new Text("You Won!");
            resultText.setFill(Color.GREEN);
            gameOverLayout.setStyle("-fx-background-color: #004400;");
        } else {
            resultText = new Text("Game Over!");
            resultText.setFill(Color.RED);
            gameOverLayout.setStyle("-fx-background-color: #440000;");
        }
        resultText.setFont(Font.font(36));

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setOnAction(e -> showWelcomeScreen(primaryStage));

        gameOverLayout.getChildren().addAll(resultText, playAgainButton);

        Scene gameOverScene = new Scene(gameOverLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(gameOverScene);
    }
}
