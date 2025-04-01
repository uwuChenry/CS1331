package HW5;
/**
 * The Media class.
 * @author Po Cheng Chen
 * @version 1.0
 */
public abstract class Media implements Comparable<Media> {

    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * Constructs a Media object with the specified genre, name, rating, and rental price.
     *
     * @param genre       the genre of the media
     * @param name        the name of the media
     * @param rating      the rating of the media
     * @param rentalPrice the rental price of the media
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * Constructs a Media object with the specified genre, name, and rating.
     * The rental price is set to a default value of $7.00.
     *
     * @param genre  the genre of the media
     * @param name   the name of the media
     * @param rating the rating of the media
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    /**
     * Gets the name of the media.
     *
     * @return the name of the media
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the rating of the media.
     *
     * @return the rating of the media
     */
    public int getRating() {
        return rating;
    }

    /**
     * Gets the rental price of the media.
     *
     * @return the rental price of the media
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Gets the genre of the media.
     *
     * @return the genre of the media
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Returns a string representation of the media.
     *
     * @return a string containing the genre, name, rating, and rental price of the media
     */
    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f",
                genre, name, rating, rentalPrice);
    }

    /**
     * Compares this media object to another object for equality.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;
        return this.rating == media.rating
            && Double.compare(media.rentalPrice, this.rentalPrice) == 0
            && this.genre == media.genre
            && this.name.equals(media.name);
    }

    /**
     * Compares this media object to another media object for ordering.
     * The comparison is based on genre, then name, and finally rating.
     *
     * @param other the media object to compare to
     * @return a negative integer, zero, or a positive integer
     */
    @Override
    public int compareTo(Media other) {
        int genreComparison = Integer.compare(this.genre.ordinal(), other.genre.ordinal());
        if (genreComparison != 0) {
            return genreComparison;
        }
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.rating, other.rating);
    }
}
