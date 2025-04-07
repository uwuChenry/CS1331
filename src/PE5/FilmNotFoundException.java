package PE5;
/**
 * FilmNotFoundException.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class FilmNotFoundException extends Exception {
    /**
     * Constructs a FilmNotFoundException.
     *
     * @param movie the name of the film that was not found
     */
    public FilmNotFoundException(String movie) {
        super(movie + " is not playing at this movie theater.");
    }
}
