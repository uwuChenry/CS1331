package HW5;
/**
 * The Movie class.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Movie extends Media {

    private int runtime;

    /**
     * Constructs a Movie object with the specified genre, name, rating, rental price, and runtime.
     *
     * @param genre       the genre of the movie
     * @param name        the name of the movie
     * @param rating      the rating of the movie
     * @param rentalPrice the rental price of the movie
     * @param runtime     the runtime of the movie in minutes
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructs a Movie object with the specified genre, name, and rating.
     * The rental price is set to a default value of $5.00, and the runtime is set to a default value of 111 minutes.
     *
     * @param genre  the genre of the movie
     * @param name   the name of the movie
     * @param rating the rating of the movie
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    /**
     * Returns a string representation of the movie.
     * This includes the genre, name, rating, rental price, and runtime.
     *
     * @return a string containing the details of the movie
     */
    @Override
    public String toString() {
        return super.toString()
            + String.format(", Runtime: %d", runtime);
    }

    /**
     * Compares this movie object to another object for equality.
     * Two movies are considered equal if they have the same attributes, including runtime.
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
        Movie movie = (Movie) other;
        return this.runtime == movie.runtime;
    }
}
