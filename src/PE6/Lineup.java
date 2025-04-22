package PE6;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Lineup class.
 *
 * @param <T> the type of data stored
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Lineup<T extends Comparable<T>> {
    private ArrayList<T> lineup;
    private boolean isAscending;

    /**
     * Constructor that takes four elements of type T.
     *
     * @param first the first element
     * @param second the second element
     * @param third the third element
     * @param fourth the fourth element
     */
    public Lineup(T first, T second, T third, T fourth) {
        lineup = new ArrayList<>(4);
        isAscending = true;

        // If any inputs are null, don't add any values
        if (first == null || second == null || third == null || fourth == null) {
            return;
        }
        lineup.add(first);
        lineup.add(second);
        lineup.add(third);
        lineup.add(fourth);
    }

    /**
     * Returns a string representation of the lineup in the format.
     *
     * @return string representation of the lineup
     */
    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < 4; i++) {
            if (i < lineup.size()) {
                out += lineup.get(i);
            } else {
                out += "null";
            }
            if (i < 3) {  // Using 3 instead of 4-1 for clarity
                out += " -> ";
            }
        }
        return out;
    }

    /**
     * Adds an element to the lineup in the proper position based on ordering.
     *
     * @param element the element to add
     * @return true if the element was added, false otherwise
     */
    public boolean add(T element) {
        if (element == null || lineup.size() >= 4) {
            return false;
        }
        lineup.add(element);
        sort();
        return true;
    }

    /**
     * Default constructor for creating an empty lineup.
     *
     * @param isAscending ascending if true, descending if false
     */
    public Lineup(boolean isAscending) {
        lineup = new ArrayList<>(4);
        this.isAscending = isAscending;
    }



    /**
     * Removes the first occurrence of the specified element.
     *
     * @param element the element to remove
     * @return true if the element was found and removed, false otherwise
     */
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        return lineup.remove(element);
    }

    /**
     * Reverses.
     */
    public void reverseLineup() {
        Collections.reverse(lineup);
        isAscending = !isAscending; // Always reverse the value of isAscending
    }

    /**
     * Returns true if the lineup contains the element.
     *
     * @param element the element to check for
     * @return true if the lineup contains the element, false otherwise
     */
    public boolean contains(T element) {
        return lineup.contains(element);
    }

    /**
     * Returns the number of elements in the lineup.
     *
     * @return the number of elements in the lineup
     */
    public int size() {
        int counter = 0;
        for (T element : lineup) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }
    private void sort() {
        Collections.sort(lineup);
        if (!isAscending) {
            Collections.reverse(lineup);
        }
    }

    /**
     * Main method to test.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create two instances of Lineup
        System.out.println("Creating lineups...");
        Lineup<Integer> ascendingLineup = new Lineup<>(true);
        Lineup<String> descendingLineup = new Lineup<>(false);

        // Test empty lineups
        System.out.println("\nTesting empty lineups:");
        System.out.println("Empty ascending lineup: " + ascendingLineup);
        System.out.println("Empty descending lineup: " + descendingLineup);
        System.out.println("Empty lineup size: " + ascendingLineup.size());

        // Test adding elements
        System.out.println("\nTesting add method:");
        System.out.println("Adding 2 to ascending: " + ascendingLineup.add(2));
        System.out.println("Adding 1 to ascending: " + ascendingLineup.add(1));
        System.out.println("Adding 3 to ascending: " + ascendingLineup.add(3));
        System.out.println("Ascending lineup: " + ascendingLineup);

        System.out.println("Adding B to descending: " + descendingLineup.add("B"));
        System.out.println("Adding A to descending: " + descendingLineup.add("A"));
        System.out.println("Adding C to descending: " + descendingLineup.add("C"));
        System.out.println("Descending lineup: " + descendingLineup);

        // Test edge case: adding null
        System.out.println("\nTesting edge cases for add:");
        System.out.println("Adding null to ascending: " + ascendingLineup.add(null));

        // Test edge case: filling lineup to capacity and beyond
        System.out.println("Adding 4 to ascending: " + ascendingLineup.add(4));
        System.out.println("Full ascending lineup: " + ascendingLineup);
        System.out.println("Adding 5 to full lineup: " + ascendingLineup.add(5));

        // Test contains method
        System.out.println("\nTesting contains method:");
        System.out.println("ascendingLineup contains 2: " + ascendingLineup.contains(2));
        System.out.println("descendingLineup contains D: " + descendingLineup.contains("D"));
        System.out.println("ascendingLineup contains 5: " + ascendingLineup.contains(5));

        // Test size method
        System.out.println("\nTesting size method:");
        System.out.println("ascendingLineup size: " + ascendingLineup.size());
        System.out.println("descendingLineup size: " + descendingLineup.size());

        // Test remove method
        System.out.println("\nTesting remove method:");
        System.out.println("Remove 2 from ascendingLineup: " + ascendingLineup.remove(2));
        System.out.println("After removal: " + ascendingLineup);
        System.out.println("Size after removal: " + ascendingLineup.size());

        // Test edge case: removing element not in lineup
        System.out.println("Remove 7 (not in lineup): " + ascendingLineup.remove(7));

        // Test edge case: removing null
        System.out.println("Remove null: " + ascendingLineup.remove(null));

        // Test reverseLineup method
        System.out.println("\nTesting reverseLineup method:");
        System.out.println("Before reverse: " + ascendingLineup);
        ascendingLineup.reverseLineup();
        System.out.println("After reverse: " + ascendingLineup);

        // Test second constructor
        System.out.println("\nTesting constructor with four elements:");
        Lineup<Integer> fullLineup = new Lineup<>(1, 2, 3, 4);
        System.out.println("Full lineup: " + fullLineup);

        // Test edge case: constructor with null elements
        System.out.println("\nTesting constructor with null elements:");
        Lineup<String> nullLineup = new Lineup<>("A", null, "C", "D");
        System.out.println("Lineup with null element: " + nullLineup);

        // Test add after remove to verify array still works correctly
        System.out.println("\nTesting add after remove:");
        ascendingLineup.add(5);
        System.out.println("After adding 5: " + ascendingLineup);
    }

}
