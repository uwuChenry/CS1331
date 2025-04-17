package HW8LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of the Iterator interface for the LinkedList class.
 * This iterator allows for traversal of a LinkedList in a sequential manner.
 * It maintains a reference to the next node to be processed in the iteration.
 *
 * @param <T> the type of elements stored in the linked list being iterated
 * @author Po Cheng Chen
 * @version 1.0
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * Constructs a new iterator for the specified linked list.
     * The iterator is positioned at the beginning of the list.
     *
     * @param list the linked list to be iterated
     * @throws IllegalArgumentException if the specified list is null
     */
    public LinkedListIterator(LinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        this.next = list.getHead();
    }

    /**
     * Returns whether the iteration has more elements.
     * This method returns true if the next node reference is not null.
     *
     * @return true if the iteration has more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return next != null;
    }

    /**
     * Returns the next element in the iteration.
     * This method advances the iterator to the next node.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        T data = next.getData();
        next = next.getNext();
        return data;
    }
}
