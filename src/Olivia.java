import java.util.ArrayList;

public class Olivia {
    private static double budget = 1000;
    private static ArrayList<Media> cart = new ArrayList<>();
    private static boolean canUseConsole = true;

    public static void printBudget() {
        System.out.println("Budget: " + budget);
    }

    public static void printCart() {
        System.out.println("Cart: ");
        for (Media media : cart) {
            System.out.println(media);
        }
    }

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
