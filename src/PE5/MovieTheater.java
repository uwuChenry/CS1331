package PE5;
import java.util.ArrayList;

/**
 * MovieTheater class.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    /**
     * Constructs a new MovieTheater.
     *
     * @param movies the list of available movies
     * @param watched the list of movies that have been watched
     */
    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        if (movies == null) {
            this.movies = new ArrayList<>();
        } else {
            this.movies = new ArrayList<>(movies);
        }
        if (watched == null) {
            this.watched = new ArrayList<>();
        } else {
            this.watched = new ArrayList<>(watched);
        }
    }

    /**
     * Checks if all movies in the interestingMovies list are available at this theater.
     * Throws an exception if any movie is missing.
     *
     * @param interestingMovies list of movies to check for availability
     * @throws IllegalArgumentException if interestingMovies is null
     * @throws FilmNotFoundException if a movie from interestingMovies is not available at this theater
     */
    public void throwIfMoviesMissing(ArrayList<String> interestingMovies)
        throws IllegalArgumentException, FilmNotFoundException {
        if (interestingMovies == null) {
            throw new IllegalArgumentException("Interesting movies list cannot be null.");
        }
        for (String movie : interestingMovies) {
            if (!movies.contains(movie)) {
                throw new FilmNotFoundException(movie);
            }
        }
    }

    /**
     * Marks a movie as watched by adding it to the watched list.
     * The movie must be available at this theater and must not have been watched before.
     *
     * @param movie the movie to watch
     * @throws IllegalArgumentException if the movie is null
     * @throws FilmNotFoundException if the movie is not available at this theater
     * @throws AlreadyWatchedException if the movie has already been watched
     */
    public void watchMovie(String movie)
        throws IllegalArgumentException, FilmNotFoundException, AlreadyWatchedException {
        if (movie == null) {
            throw new IllegalArgumentException("Movie name cannot be null.");
        }
        if (!movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        }
        if (watched.contains(movie)) {
            throw new AlreadyWatchedException();
        }
        watched.add(movie);
    }

    /**
     * Determines which recommended movies to see at this theater based on what's available and not yet watched.
     *
     * @param recommendedMovies list of movies recommended by a friend
     * @return list of movies that are both recommended and available for watching (not watched yet)
     * @throws IllegalArgumentException if recommendedMovies is null
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        if (recommendedMovies == null) {
            return new ArrayList<>();
        }
        ArrayList<String> willSee = new ArrayList<>();
        for (String movie : recommendedMovies) {
            if (movies.contains(movie) && !watched.contains(movie)) {
                willSee.add(movie);
            }
        }
        return willSee;
    }

    /**
     * For testing.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        movies.add("a");
        movies.add("b");
        movies.add("c");
        movies.add("d");
        movies.add("e");

        ArrayList<String> watched = new ArrayList<>();
        watched.add("b"); // In movies list
        watched.add("f"); // Not in movies list

        ArrayList<String> recommended = new ArrayList<>();
        recommended.add("d"); // In movies only
        recommended.add("f"); // In watched only
        recommended.add("g"); // In neither list

        MovieTheater theater = new MovieTheater(movies, watched);

        try {
            theater.throwIfMoviesMissing(movies);
            theater.watchMovie("c");
            theater.watchMovie("f");
            theater.watchMovie("g");
            ArrayList<String> toWatch = theater.selectRecommended(recommended);
        } catch (FilmNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (AlreadyWatchedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took a   look at the movies!");
        }
    }
}
