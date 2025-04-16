import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic linked list implementation that stores elements of type T.
 * This linked list is a singly linked structure that implements the List interface.
 * It maintains a reference to the head of the list and keeps track of its size.
 * The list does not allow null elements.
 *
 * @param <T> the type of elements stored in this linked list
 * @author Po Cheng Chen
 * @version 1.0
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructs an empty linked list.
     * The head is set to null and the size is initialized to 0.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Constructs a linked list containing the elements of the specified array.
     * The elements are added in the order they appear in the array.
     *
     * @param data the array whose elements are to be placed into this list
     * @throws IllegalArgumentException if the array is null or contains null elements
     */
    public LinkedList(T[] data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        for (T datum : data) {
            if (datum == null) {
                throw new IllegalArgumentException("Element cannot be null");
            }
            add(datum); // keep adding to end
        }
    }

    /**
     * Returns the head node of this linked list.
     *
     * @return the head node of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     * The elements are placed into the array in the same order they appear in the list.
     * The implementation uses the iterator to traverse the list.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        Iterator<T> iterator = iterator();

        int index = 0;
        while (iterator.hasNext()) {
            array[index] = iterator.next();
            index++;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(element));
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<>(element, current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T removed;
        if (index == 0) {
            removed = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removed = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removed;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.getData().equals(element)) {
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(element)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new NoSuchElementException("Element not found in list: " + element);
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }
}