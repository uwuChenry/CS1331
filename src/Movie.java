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
        return super.toString() + 
                String.format(", Runtime: %d", runtime);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        Movie movie = (Movie) other;
        return this.runtime == movie.runtime;
    }



}
