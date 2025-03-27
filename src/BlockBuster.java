import java.util.ArrayList;

/**
 * The Blockbuster class represents a collection of media items.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * Constructs a new Blockbuster instance with an empty inventory.
     */
    public Blockbuster() {
        inventory = new ArrayList<>();
    }

    /**
     * Adds a media item to the inventory.
     *
     * @param media the media item to add
     */
    public void addMedia(Media media) {
        inventory.add(media);
    }

    /**
     * Removes a media item from the inventory.
     *
     * @param media the media item to remove
     * @return the removed media item if it was found, or {@code null} if it was not found
     */
    public Media removeMedia(Media media) {
        int index = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(media)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return inventory.remove(index);
        } else {
            return null;
        }
    }

    /**
     * Sorts the inventory of media items in ascending order based on their natural ordering.
     */
    public void sortMedia() {
        int size = inventory.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (inventory.get(j).compareTo(inventory.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Media temp = inventory.get(i);
                inventory.set(i, inventory.get(minIndex));
                inventory.set(minIndex, temp);
            }
        }
    }

    /**
     * Finds a media item in the inventory using binary search.
     * The inventory must be sorted before calling this method.
     *
     * @param other the media item to find
     * @return the media item if found, or {@code null} if not found
     */
    public Media findMedia(Media other) {
        int left = 0;
        int right = inventory.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = inventory.get(mid).compareTo(other);
            if (comparison == 0) {
                return inventory.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /**
     * Retrieves the most popular movie in the inventory.
     *
     * @return the most popular movie, or null if no movies
     */
    public Movie getMostPopularMovie() {
        Movie mostPopular = null;
        for (Media media : inventory) {
            if (media instanceof Movie) {
                if (mostPopular == null || media.getRating() >= mostPopular.getRating()) {
                    if (mostPopular == null) {
                        mostPopular = (Movie) media;
                    }
                    if (media.getRating() > mostPopular.getRating()) {
                        mostPopular = (Movie) media;
                    }
                    if (media.getRating() == mostPopular.getRating()
                        && media.getName().compareTo(mostPopular.getName()) < 0) {
                        mostPopular = (Movie) media;
                    }
                }
            }
        }
        return mostPopular;
    }

    /**
     * Prints all movies.
     */
    public void printAllMovie() {
        for (Media media : inventory) {
            if (media instanceof Movie) {
                System.out.println(media);
            }
        }
    }
}
