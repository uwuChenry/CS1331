import java.util.ArrayList;

public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart;
    private static boolean canUseConsole;

    public static boolean addToCart(Media media, Blockbuster store) {
        if (budget < media.getRentalPrice()) return false;
        Media foundMedia = store.findMedia(media);
        if (foundMedia == null) return false;

        if (media instanceof VideoGame && !canUseConsole) {
            return false;
        }

        Media removedMedia = store.removeMedia(foundMedia);
        if (removedMedia != null) {
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
