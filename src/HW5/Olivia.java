package HW5;
import java.util.ArrayList;

/**
 * The Olivia class represents a user who interacts with a Blockbuster store.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Olivia {

    private static double budget = 1000;
    private static ArrayList<Media> cart = new ArrayList<>();
    private static boolean canUseConsole = true;

    // public static void printBudget() {
    //     System.out.println("Budget: " + budget);
    // }

    // public static void printCart() {
    //     System.out.println("Cart: ");
    //     for (Media media : cart) {
    //         System.out.println(media);
    //     }
    // }

    /**
     * Add a media item to the cart.
     *
     * @param media the media item to add to the cart
     * @param store the Blockbuster store to rent from
     * @return true if the media was successfully added to the cart
     */
    public static boolean addToCart(Media media, Blockbuster store) {
        if (budget < media.getRentalPrice()) {
            System.out.println("Not enough budget");
            return false;
        }
        Media foundMedia = store.findMedia(media);
        if (foundMedia == null) {
            System.out.println("Media not found");
            return false;
        }

        if (media instanceof VideoGame && !canUseConsole) {
            System.out.println("Cannot rent video game without console");
            return false;
        }

        Media removedMedia = store.removeMedia(foundMedia);
        if (removedMedia != null) {
            System.out.println("Added to cart: " + removedMedia);
            cart.add(removedMedia);
            budget -= removedMedia.getRentalPrice();
            return true;
        }
        return false;
    }

    /**
     * Removes a media item from the cart and returns it to the store.
     *
     * @param media the media item to remove from the cart
     * @param store the Blockbuster store to return the media to
     */
    public static void changeMind(Media media, Blockbuster store) {
        int index = -1;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(media)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Media removedMedia = cart.remove(index);
            store.addMedia(removedMedia);
            budget += removedMedia.getRentalPrice();
        }
    }
}
