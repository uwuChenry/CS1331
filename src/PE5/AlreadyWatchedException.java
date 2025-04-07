package PE5;
/**
 * Already Watched Exception unchecked.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class AlreadyWatchedException extends RuntimeException {
    /**
     * Constructs a new AlreadyWatchedException.
     */
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}
