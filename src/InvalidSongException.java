public class InvalidSongException extends Exception {

    public InvalidSongException(String message) {
        super(message);
    }

    public InvalidSongException() {
        super("Invalid Song");
    }
}
