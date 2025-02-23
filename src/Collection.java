import java.util.Random;

public class Collection {
    private Card[] binder;
    private int cardsOwned;


    public Collection(Card[] binder) {
        this.binder = binder;
        this.cardsOwned = binder.length;
    }

    public Collection() {
        this.binder = new Card[4];
        this.cardsOwned = 0;
    }

    public Card addCard(int index, Card card) {
        if (index < 0 || index >= binder.length || card == null) {
            System.out.println("Cannot add a card to this spot");
            return null;
        }
        if (binder[index] != null) {
            Card old = binder[index];
            binder[index] = card;
            System.out.println("Replaced: " + old);
            return old;
        } else {
            binder[index] = card;
            cardsOwned++;
            System.out.println("Inserted: " + card);
            return null;
        }
    }

    public Card sellCard(int index) {
        if (index < 0 || index >= binder.length || binder[index] == null) {
            System.out.println("There was no card to sell!");
            return null;
        }
        Card sold = binder[index];
        binder[index] = null;
        cardsOwned--;
        System.out.println("Sold: " + sold);
        return sold;
    }

    public void showCertainCards(int conditionThreshold) {
        for (Card card : binder) {
            if (card != null && card.getCondition() > conditionThreshold) {
                System.out.println(card);
            }
        }
    }

    public void restoreAllCards() {
        Random rand = new Random(2025);
        boolean restored = false;
        for (Card card : binder) {
            if (card != null && card.isRestorable()) {
                int temp = card.getCondition();
                int increase = rand.nextInt(9) + 1;
                System.out.println("Restored to " + temp + increase + ": " + card);
                card.setCondition(temp + increase);
                restored = true;
            }
        }
        if (!restored) {
            System.out.println("There were no cards to restore");
        }
    }
    public void battle(int index) {
        Random rand = new Random(2025);
        int decrease = rand.nextInt(9) + 1;
        if (index < 0 || index >= binder.length || binder[index] == null) {
            System.out.println("Cannot battle with a card at this spot");
        } else {
            Card card = binder[index];
            int temp = card.getCondition();
            card.setCondition(temp - decrease);
            System.out.println("Used: " + card);
        }
    }

    public String toString() {
        if (cardsOwned == 0) {
            return "I own no cards!";
        } else {
            String temp = String.format("I own %d cards.", cardsOwned);
            for (Card card : binder) {
                if (card != null) {
                    temp += "\n" + card;
                }
            }
            return temp;
        }
    }
}
