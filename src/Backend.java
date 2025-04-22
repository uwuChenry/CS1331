import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Backend for a JungeonJrawler game.
 * Use this class to implement your Dungeon Crawler application for HW09!
 * DO NOT MODIFY THIS FILE!
 *
 * @author CS 1331 TAs
 * @version 13.31
 */
public class Backend {
    private final List<Rectangle> walls;
    private final Rectangle goalRect;
    private final Rectangle playerRect;
    private final Rectangle enemy1Rect;
    private final Rectangle enemy2Rect;


    /**
     * Constructs a backend instance to initialize fields that aid in the game logic.
     *
     * @param walls      the walls of the maze
     * @param goalRect   the rectangle representing the goal/exit door
     * @param playerRect the rectangle representing the player
     * @param enemy1Rect the rectangle representing enemy 1
     * @param enemy2Rect the rectangle representing enemy 2
     */
    public Backend(
            List<Rectangle> walls, Rectangle goalRect,
            Rectangle playerRect,
            Rectangle enemy1Rect, Rectangle enemy2Rect
    ) {
        this.walls = walls;
        this.goalRect = goalRect;
        this.playerRect = playerRect;
        this.enemy1Rect = enemy1Rect;
        this.enemy2Rect = enemy2Rect;
    }


    /**
     * Returns a boolean representing whether there will be a collision with a wall at the projected player position.
     *
     * @param newX the projected x position of the player
     * @param newY the projected y position of the player
     * @return whether there will be a collision with a wall at the projected player position
     */
    public boolean wallCollision(double newX, double newY) {
        Rectangle newPosition = new Rectangle(newX, newY, playerRect.getWidth(), playerRect.getHeight());

        for (Rectangle wall : walls) {
            if (newPosition.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a boolean representing whether there will be a collision with an enemy at the projected player position.
     *
     * @param newX the projected x position of the player
     * @param newY the projected y position of the player
     * @return whether there will be a collision with an enemy at the projected player position
     */
    public boolean enemyCollision(double newX, double newY) {
        Rectangle newPosition = new Rectangle(newX, newY, playerRect.getWidth(), playerRect.getHeight());

        for (Rectangle enemy : List.of(enemy1Rect, enemy2Rect)) {
            if (newPosition.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Enemy1 chases the player and returns a double[] representing [newX, newY] of the enemy.
     *
     * @return a double[] representing the [newX, newY] of the enemy
     */
    public double[] enemy1ChasePlayer() {
        return enemyChasePlayer(enemy1Rect);
    }

    /**
     * Enemy2 chases the player and returns a double[] representing [newX, newY] of the enemy.
     *
     * @return a double[] representing the [newX, newY] of the enemy
     */
    public double[] enemy2ChasePlayer() {
        return enemyChasePlayer(enemy2Rect);
    }

    /**
     * Private helper method that has an enemy in general chase the player.
     *
     * @param enemy the enemy that is chasing the player
     * @return a double[] representing the [newX, newY] of the enemy
     */
    private double[] enemyChasePlayer(Rectangle enemy) {
        if (playerRect.getX() > 200 && playerRect.getY() < 420) {
            double dx = playerRect.getX() - enemy.getX();
            double dy = playerRect.getY() - enemy.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance > 0) {
                double moveX = 2.75 * dx / distance;
                double moveY = 2.75 * dy / distance;
                return new double[]{enemy.getX() + moveX, enemy.getY() + moveY};
            }
        }

        return new double[]{enemy.getX(), enemy.getY()};
    }

    /**
     * Returns a boolean representing whether the player has reached the goal/exit door.
     *
     * @return whether the player has reached the goal/exit door
     */
    public boolean goalReached() {
        return playerRect.getBoundsInParent().intersects(goalRect.getBoundsInParent());
    }

    /**
     * Builds a maze by creating wall rectangles and fills each rectangle with the desired color.
     *
     * @param wallColor the color of the maze walls
     * @return a list of rectangles representing the walls
     */
    public static List<Rectangle> buildMaze(Color wallColor) {
        final double width = 800;
        final double height = 600;

        List<Rectangle> walls = new ArrayList<>();

        // create the start hall walls
        Rectangle startHallRightWall1 = new Rectangle(width * 2 / 3 + 40, height - 90, 10, 70);
        Rectangle startHallTopWall1 = new Rectangle(140, height - 90, width * 2 / 3 - 90, 10);
        Rectangle startHallBottomWall1 = new Rectangle(70, height - 20, width * 2 / 3 - 20, 10);
        Rectangle startHallLeftWall1 = new Rectangle(70, 200, 10, height - 220);
        Rectangle startHallRightWall2 = new Rectangle(140, 270, 10, height - 350);
        Rectangle startHallTopWall2 = new Rectangle(70, 200, 140, 10);
        Rectangle startHallBottomWall2 = new Rectangle(140, 270, 70, 10);

        // Center room right wall with gap
        Rectangle startHallRightWall3 = new Rectangle(width * 2 / 3 + 56.5, 420, 10, 20);
        Rectangle startHallRightWall4 = new Rectangle(width * 2 / 3 + 56.5, 160, 10, 190);

        walls.add(startHallRightWall1);
        walls.add(startHallTopWall1);
        walls.add(startHallBottomWall1);
        walls.add(startHallLeftWall1);
        walls.add(startHallRightWall2);
        walls.add(startHallTopWall2);
        walls.add(startHallBottomWall2);
        walls.add(startHallRightWall3);
        walls.add(startHallRightWall4);

        // create center room walls
        double xCoordOfRoom = 200, yCoordOfRoom = 150, roomWidth = width / 2, roomHeight = height / 2;
        Rectangle topWall = new Rectangle(xCoordOfRoom, yCoordOfRoom, roomWidth, 10);
        Rectangle leftWall1 = new Rectangle(xCoordOfRoom, yCoordOfRoom, 10, 60);
        Rectangle leftWall2 = new Rectangle(200, 270, 10, roomHeight - 120);
        Rectangle bottomWall = new Rectangle(xCoordOfRoom, yCoordOfRoom + roomHeight - 10, roomWidth, 10);
        walls.add(topWall);
        walls.add(leftWall1);
        walls.add(leftWall2);
        walls.add(bottomWall);

        // create end hallway walls
        double xCoordOfHall = xCoordOfRoom + roomWidth,
                topYOfHall = 340,
                bottomYOfHall = 410,
                hallWidth = width - 100 - xCoordOfHall;
        Rectangle topOfHall = new Rectangle(xCoordOfHall - 10.5, topYOfHall, hallWidth - 20, 10);
        Rectangle bottomOfHall = new Rectangle(xCoordOfHall - 10.5, bottomYOfHall, hallWidth + 50, 10);
        Rectangle rightOfHall = new Rectangle(xCoordOfHall + 39.5 + hallWidth, bottomYOfHall - 280, 10, 290);
        Rectangle leftOfHall = new Rectangle(xCoordOfHall + hallWidth - 40.5, topYOfHall - 210, 10, 210);
        walls.add(topOfHall);
        walls.add(bottomOfHall);
        walls.add(rightOfHall);
        walls.add(leftOfHall);

        // set the color of the walls
        for (Rectangle wall : walls) {
            wall.setFill(wallColor);
        }

        return walls;
    }

    /**
     * Generates a random name of length at least 2 and up to 4.
     *
     * @return the randomly generated name
     */
    public static String generateRandomName() {
        char[] consonants = {
            'b', 'c', 'd', 'f', 'g',
            'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's',
            't', 'v', 'w', 'x', 'y',
            'z'
        };
        final char[] vowels = {
            'a', 'e', 'i', 'o', 'u',
            'y'
        };
        final Random rand = new Random();

        String randomName = "";
        for (int i = 0; i < rand.nextInt(3) + 2; ++i) {
            if (i % 2 != 0) {
                // every odd letter is a consonant
                randomName += consonants[rand.nextInt(consonants.length)];
            } else {
                // every even letter is a vowel
                randomName += vowels[rand.nextInt(vowels.length)];
            }
            if (i == 0) {
                randomName = randomName.toUpperCase();
            }
        }

        return randomName;
    }
}