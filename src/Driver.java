public class Driver {
    public static void main(String[] args) {

        System.out.println("CARD CONSTRUCTION TEST\n==INTENDED==\nCard condition: Damaged");
        System.out.println("Card condition: Excellent\nCard Condition: Excellent");
        System.out.println("Card condition: Excellent\nCard Condition: Excellent");
        System.out.println("Card condition: Fine\n==ACTUAL==");

        Card junior = new Card(20, "Magikarp", PokemonType.WATER, "Flail", 49);
        Card senior = new Card(100, "Gyrados", PokemonType.WATER);
        Card ditto = new Card();
        Card fourth = new Card(178, "MissingNO", PokemonType.GROUND, "Pay Day", 101);
        Card fifth = new Card(178, "MissingNO", PokemonType.GROUND, "Scratch", 39);
        Card starter = new Card(45, "Torchic", PokemonType.FIRE, "Ember", 50);

        Collection addDeck = new Collection();
        Collection refDeck = new Collection(new Card[]{junior, senior, ditto, fifth, starter});

        System.out.println("\n\n\nADD CARD TEST\n==INTENDED==");
        System.out.println("I own no cards!\nThere were no cards to restore.");
        System.out.println("Inserted: <100, Gyrados, WATER, Hyperbeam, 80, true>\nnull");
        System.out.println("Inserted: <20, Magikarp, WATER, Flail, 49, false>\nnull");
        System.out.println("Cannot add a card to this spot.\nnull");
        System.out.println("Inserted: <178, MissingNO, GROUND, Pay Day, 80, true>\nnull");
        System.out.println("Replaced: <178, MissingNO, GROUND, Pay Day, 80, true>");
        System.out.println("<178, MissingNO, GROUND, Pay Day, 80, true>\n==ACTUAL==");

        System.out.println(addDeck);
        addDeck.restoreAllCards();
        System.out.println(addDeck.addCard(1, senior));
        System.out.println(addDeck.addCard(0, junior));
        System.out.println(addDeck.addCard(5, fourth));
        System.out.println(addDeck.addCard(3, fourth));
        System.out.println(addDeck.addCard(3, starter));

        System.out.println("\n\n\nCOLLECTION PRINT TEST\n==INTENDED==\nI have 3 cards.");
        System.out.println("<20, Magikarp, WATER, Flail, 49, false>");
        System.out.println("<100, Gyrados, WATER, Hyperbeam, 80, true>");
        System.out.println("<45, Torchic, FIRE, Ember, 50, true>");

        System.out.println("I have 5 cards.");
        System.out.println("<20, Magikarp, WATER, Flail, 49, false>");
        System.out.println("<100, Gyrados, WATER, Hyperbeam, 80, true>");
        System.out.println("<120, Ditto, NORMAL, Imposter, 89, true>");
        System.out.println("<178, MissingNO, GROUND, Scratch, 80, true>");
        System.out.println("<45, Torchic, FIRE, Ember, 50, true>");
        System.out.println("==ACTUAL==\n" + addDeck + "\n" + refDeck);

        System.out.println("\n\n\nSELL TEST\n==INTENDED==");
        System.out.println("There was no card to sell!\nnull");
        System.out.println("Sold: <20, Magikarp, WATER, Flail, 49, false>\n<20, Magikarp, WATER, Flail, 49, false>");

        // System.out.println("There was no card to sell!\nnull\n==ACTUAL==");
        System.out.println(addDeck.sellCard(4));
        System.out.println(addDeck.sellCard(0));
        System.out.println(refDeck.sellCard(3));
        System.out.println(refDeck.sellCard(3));

        System.out.println("\n\n\nCERTAIN CARDS TEST\n==INTENDED==");
        System.out.println("<120, Ditto, NORMAL, Imposter, 89, true>");
        System.out.println("<100, Gyrados, WATER, Hyperbeam, 80, true>");
        System.out.println("<45, Torchic, FIRE, Ember, 50, true>");
        System.out.println("==ACTUAL==");
        refDeck.showCertainCards(80);
        addDeck.showCertainCards(49);

        System.out.println("\n\n\nBATTLE TEST\n==INTENDED==");
        System.out.println("Cannot battle with a card at this spot.");
        System.out.println("Used: <20, Magikarp, WATER, Flail, 42, false>");
        System.out.println("Used: <45, Torchic, FIRE, Ember, 43, false>");
        System.out.println("Cannot battle with a card at this spot.");

        System.out.println("==ACTUAL==");
        addDeck.battle(2);
        refDeck.battle(0);
        refDeck.battle(4);
        addDeck.battle(-1);

        System.out.println("\n\n\nRESTORE TEST\n==INTENDED==");
        System.out.println("Restored to 87: <100, Gyrados, WATER, Hyperbeam, 80, true>");
        //Notice gyrados is restored twice as both collections contain it
        System.out.println("Restored to 93: <100, Gyrados, WATER, Hyperbeam, 87, true>");
        System.out.println("Restored to 95: <120, Ditto, NORMAL, Imposter, 89, true>");
        System.out.println("There were no cards to restore.");
        System.out.println("==ACTUAL==");
        addDeck.restoreAllCards();
        refDeck.restoreAllCards();
        addDeck.restoreAllCards();
        // System.out.println("FINAL COUNT CHECK: 2 cards in the first collection, 4 in the second");
        System.out.println(addDeck + "\n" + refDeck);
    }
}