package HW6;
/**
 * Exception for invalid songs.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class InvalidSongException extends Exception {

    /**
     * Constructs a new InvalidSongException with the specified detail message.
     *
     * @param message message
     */
    public InvalidSongException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidSongException with message: "Invalid Song".
     */
    public InvalidSongException() {
        super("Invalid Song");
    }
}
