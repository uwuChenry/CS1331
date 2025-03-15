public abstract class Media implements Comparable <Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f", 
                genre, name, rating, rentalPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return this.rating == media.rating &&
               Double.compare(media.rentalPrice, this.rentalPrice) == 0 &&
               this.genre == media.genre &&
               this.name.equals(media.name);
    }
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
