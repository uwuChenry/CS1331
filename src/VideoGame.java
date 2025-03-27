/**
 * The VideoGame class represents a specific type of media, a video game, which extends the Media class.
 * It includes additional attributes such as the maximum number of players and whether a console is required.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class VideoGame extends Media {

    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructs a VideoGame object with the specified genre, name, rating, rental price, maximum players, and console requirement.
     *
     * @param genre        the genre of the video game
     * @param name         the name of the video game
     * @param rating       the rating of the video game
     * @param rentalPrice  the rental price of the video game
     * @param maxPlayers   the maximum number of players for the video game
     * @param needConsole  whether the video game requires a console
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needConsole;
    }

    /**
     * Constructs a VideoGame object with the specified genre, name, and rating.
     * The rental price is set to a default value of $5.00, the maximum players is set to 2, 
     * and the console requirement is set to false.
     *
     * @param genre  the genre of the video game
     * @param name   the name of the video game
     * @param rating the rating of the video game
     */
    public VideoGame(Genre genre, String name, int rating) {
        super(genre, name, rating, 5.0);
        maxPlayers = 2;
        needsConsole = false;
    }

    /**
     * Returns a string representation of the video game.
     * This includes the genre, name, rating, rental price, maximum players, and console requirement.
     *
     * @return a string containing the details of the video game
     */
    @Override
    public String toString() {
        return super.toString()
            + String.format(", Players: %d, ", maxPlayers)
            + String.format("%s need a console", needsConsole ? "does" : "does not");
    }

    /**
     * Compares this video game object to another object for equality.
     * Two video games are considered equal if they have the same attributes, including maximum players and console requirement.
     *
     * @param other the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        VideoGame videoGame = (VideoGame) other;
        return this.maxPlayers == videoGame.maxPlayers
            && this.needsConsole == videoGame.needsConsole;
    }

    /**
     * Checks if the video game requires a console to play.
     *
     * @return true if the video game requires a console, false otherwise
     */
    public boolean needConsole() {
        return needsConsole;
    }
}
