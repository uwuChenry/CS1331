import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Driver class to test and demonstrate the LinkedList implementation.
 *
 * @author jndungu6
 * @version 2.0
 * 
 *
 * Note: The toArray() method returns an array via an unchecked cast.
 * Therefore, its result is stored in an Object[] to avoid ClassCastException.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Normal Functionality Tests ===");

        // Create an empty LinkedList and display its state.
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Empty list: " + list);
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("Size: " + list.size());

        // --- Demonstrate add(E element) ---
        System.out.println("\n--- Testing add(E element) ---");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding 10, 20, 30: " + list);
        System.out.println("Size: " + list.size());

        // --- Demonstrate add(int index, E element) ---
        System.out.println("\n--- Testing add(int index, E element) ---");
        // Insert at the beginning.
        list.add(0, 5);
        // Insert in the middle.
        list.add(2, 15);
        // Insert at the end (index equals size).
        list.add(list.size(), 35);
        System.out.println("After inserting at specific indices: " + list);
        System.out.println("Size: " + list.size());

        // --- Demonstrate get(int index) ---
        System.out.println("\n--- Testing get(int index) ---");
        System.out.println("Element at index 0: " + list.get(0));   // Expected: 5
        System.out.println("Element at index 3: " + list.get(3));   // Expected: 20

        // --- Demonstrate set(int index, E element) ---
        System.out.println("\n--- Testing set(int index, E element) ---");
        int replaced = list.set(1, 12); // Replace element at index 1 (was 10)
        System.out.println("Replaced element " + replaced + " at index 1 with 12.");
        System.out.println("List after set: " + list);

        // --- Demonstrate contains(E element) ---
        System.out.println("\n--- Testing contains(E element) ---");
        System.out.println("List contains 20? " + list.contains(20));   // Expected: true
        System.out.println("List contains 100? " + list.contains(100)); // Expected: false

        // --- Demonstrate iterator() ---
        System.out.println("\n--- Testing iterator() ---");
        Iterator<Integer> iter = list.iterator();
        System.out.print("Iterator over elements: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // --- Demonstrate toArray() ---
        // Note: The toArray() method uses (T[]) new Object[size].
        // To avoid a ClassCastException at runtime, we assign its result to an Object[].
        System.out.println("\n--- Testing toArray() ---");
        Object[] arr = list.toArray();
        System.out.print("Array contents: ");
        for (Object element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        // --- Demonstrate remove() (removes head element) ---
        System.out.println("\n--- Testing remove() ---");
        int removedHead = list.remove();
        System.out.println("Removed head element: " + removedHead);
        System.out.println("List after removing head: " + list);

        // --- Demonstrate remove(int index) ---
        System.out.println("\n--- Testing remove(int index) ---");
        int removedAtIndex = list.remove(2); // Remove element at index 2
        System.out.println("Removed element at index 2: " + removedAtIndex);
        System.out.println("List after removal by index: " + list);

        // --- Demonstrate remove(E element) ---
        System.out.println("\n--- Testing remove(E element) ---");
        int removedByVal = list.remove(Integer.valueOf(12));
        System.out.println("Removed element 12: " + removedByVal);
        System.out.println("List after removal by element: " + list);

        // --- Demonstrate clear() ---
        System.out.println("\n--- Testing clear() ---");
        list.clear();
        System.out.println("List after clear: " + list);
        System.out.println("Size after clear: " + list.size());
        System.out.println("isEmpty after clear: " + list.isEmpty());

        // --- Demonstrate constructor with an array (allowed case) ---
        System.out.println("\n--- Testing constructor with array ---");
        Integer[] numbers = {1, 2, 3, 4, 5};
        LinkedList<Integer> listFromArray = new LinkedList<>(numbers);
        System.out.println("LinkedList constructed from array: " + listFromArray);


        // ===============================
        // Allowed Edge Cases Tests
        // ===============================
        System.out.println("\n=== Allowed Edge Cases Tests ===");

        // Edge Case 1: add(null) should throw IllegalArgumentException.
        System.out.println("\nEdge Case 1: Testing add(null)");
        try {
            list.add(null);
            System.out.println("ERROR: add(null) did not throw an exception.");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught IllegalArgumentException for add(null).");
        }

        // Edge Case 2: add(index, null) should throw IllegalArgumentException.
        System.out.println("\nEdge Case 2: Testing add(0, null)");
        try {
            list.add(0, null);
            System.out.println("ERROR: add(index, null) did not throw an exception.");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught IllegalArgumentException for add(0, null).");
        }

        // Edge Case 3: get(index) with an out-of-bounds index.
        System.out.println("\nEdge Case 3: Testing get(index) with an invalid index");
        try {
            listFromArray.get(100);
            System.out.println("ERROR: get(100) did not throw an exception.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly caught IndexOutOfBoundsException for get(100).");
        }

        // Edge Case 4: set(index, element) with an out-of-bounds index.
        System.out.println("\nEdge Case 4: Testing set(index, element) with an invalid index");
        try {
            listFromArray.set(100, 10);
            System.out.println("ERROR: set(100, 10) did not throw an exception.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly caught IndexOutOfBoundsException for set(100, 10).");
        }

        // Edge Case 5: remove() on an empty list should throw NoSuchElementException.
        System.out.println("\nEdge Case 5: Testing remove() on an empty list");
        try {
            list.clear();
            list.remove();
            System.out.println("ERROR: remove() on empty list did not throw an exception.");
        } catch (NoSuchElementException e) {
            System.out.println("Correctly caught NoSuchElementException for remove() on an empty list.");
        }

        // Edge Case 6: remove(index) on an empty list should throw NoSuchElementException.
        System.out.println("\nEdge Case 6: Testing remove(index) on an empty list");
        try {
            list.remove(0);
            System.out.println("ERROR: remove(0) on empty list did not throw an exception.");
        } catch (NoSuchElementException e) {
            System.out.println("Correctly caught NoSuchElementException for remove(0) on an empty list.");
        }

        // Edge Case 7: remove(element) for a non-existent element should throw NoSuchElementException.
        System.out.println("\nEdge Case 7: Testing remove(element) for a non-existent element");
        try {
            listFromArray.remove(Integer.valueOf(999)); // 999 is not present.
            System.out.println("ERROR: remove(999) did not throw an exception.");
        } catch (NoSuchElementException e) {
            System.out.println("Correctly caught NoSuchElementException for removing a non-existent element.");
        }

        // Edge Case 8: Constructor with null array should throw IllegalArgumentException
        System.out.println("\nEdge Case 8: Testing constructor with null array");
        try {
            LinkedList<Integer> nullList = new LinkedList<>(null);
            System.out.println("ERROR: Constructor with null array did not throw an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught IllegalArgumentException for null array constructor");
        }
        
        // Edge Case 9: Constructor with array containing null elements
        System.out.println("\nEdge Case 9: Testing constructor with array containing null elements");
        Integer[] arrayWithNull = {1, 2, null, 4, 5};
        try {
            LinkedList<Integer> nullElemList = new LinkedList<>(arrayWithNull);
            System.out.println("ERROR: Constructor with null elements did not throw an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught IllegalArgumentException for array with null elements");
        }
        
        // Edge Case 10: Testing add with negative index
        System.out.println("\nEdge Case 10: Testing add with negative index");
        try {
            listFromArray.add(-1, 100);
            System.out.println("ERROR: add(-1, 100) did not throw an exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correctly caught IndexOutOfBoundsException for add(-1, 100)");
        }
        
        // Edge Case 11: Testing operations at size boundary
        System.out.println("\nEdge Case 11: Testing add at exactly size index (should be valid)");
        LinkedList<Integer> sizeList = new LinkedList<>();
        sizeList.add(1);
        sizeList.add(2);
        try {
            sizeList.add(2, 3); // Adding at index equal to size (valid)
            System.out.println("Correctly allowed adding at index equal to size: " + sizeList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: add at size index incorrectly threw exception");
        }
        
        // Edge Case 12: Testing contains() with null
        System.out.println("\nEdge Case 12: Testing contains with null");
        try {
            listFromArray.contains(null);
            System.out.println("ERROR: contains(null) did not throw an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught IllegalArgumentException for contains(null)");
        }
        
        // Edge Case 13: Testing element equality behavior with custom objects
        System.out.println("\nEdge Case 13: Testing element equality behavior with custom objects");
        class TestObject {
            private int value;
            public TestObject(int value) { this.value = value; }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                TestObject that = (TestObject) obj;
                return value == that.value;
            }
            @Override
            public String toString() {
                return "TestObject(" + value + ")";
            }
        }
        
        LinkedList<TestObject> objectList = new LinkedList<>();
        TestObject obj1 = new TestObject(10);
        objectList.add(obj1);
        objectList.add(new TestObject(20));
        
        System.out.println("Object list: " + objectList);
        System.out.println("Contains new TestObject(10)? " + objectList.contains(new TestObject(10)));
        System.out.println("Contains same object reference? " + objectList.contains(obj1));
        
        // Edge Case 14: Testing iterator behavior after list modification
        System.out.println("\nEdge Case 14: Testing iterator behavior after list modification");
        LinkedList<Integer> iterList = new LinkedList<>();
        iterList.add(1);
        iterList.add(2);
        Iterator<Integer> iterator = iterList.iterator();
        iterList.add(3); // Modify the list after iterator is created
        
        System.out.print("Iterator elements after list modification: ");
        try {
            while(iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println("\n(Note: This shows if iterator is affected by list changes)");
        } catch (Exception e) {
            System.out.println("\nIterator threw exception after list modification: " + e.getMessage());
        }
        
        // Edge Case 15: Basic performance test with larger list
        System.out.println("\nEdge Case 15: Basic performance test with larger list");
        LinkedList<Integer> largeList = new LinkedList<>();
        int testSize = 1000; // Using a smaller size for quicker execution
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testSize; i++) {
            largeList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time to add " + testSize + " elements: " + (endTime - startTime) + "ms");
        
        // Test access time for last element
        startTime = System.currentTimeMillis();
        int lastElement = largeList.get(testSize - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time to access last element (" + lastElement + "): " + (endTime - startTime) + "ms");

        System.out.println("\n=== All tests completed ===");
    }
}