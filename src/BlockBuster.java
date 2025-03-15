import java.util.ArrayList;

public class BlockBuster {
    ArrayList <Media> inventory;

    public BlockBuster() {
        inventory = new ArrayList<>();
    }

    public void addMedia(Media media) {
        inventory.add(media);
    }

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

    public Movie getMostPopularMovie() {
        Movie mostPopular = null;
        for (Media media : inventory) {
            if (media instanceof Movie) {
                if (mostPopular == null || media.getRating() >= mostPopular.getRating()) {
                    if (media.equals(mostPopular) && media.getName().compareTo(mostPopular.getName()) < 0) {
                        mostPopular = (Movie) media;

                    }
                }
            }
        }
        return mostPopular;
    }
}
