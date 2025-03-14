public class Movie extends Media {
    private int runtime;

    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f, Runtime: %d}", 
                super.getGenre(), super.getName(), super.getRating(), super.getRentalPrice(), runtime);
    }

}
