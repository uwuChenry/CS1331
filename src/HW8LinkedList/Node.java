package HW8LinkedList;
/**
 * A generic node class used in linked data structures.
 *
 * @param <T> the type of data stored in this node
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructs a node with the specified data and next node reference.
     *
     * @param data the data to be stored in this node
     * @param next reference to the next node in the linked structure
     * @throws IllegalArgumentException if the data is null
     */
    public Node(T data, Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a node with the specified data and no next node reference.
     *
     * @param data the data to be stored in this node
     * @throws IllegalArgumentException if the data is null
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data stored in this node.
     *
     * @param data the new data to be stored in this node
     * @throws IllegalArgumentException if the data is null
     */
    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        this.data = data;
    }

    /**
     * Returns the next node in the linked structure.
     *
     * @return the next node, or null if there is no next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked structure.
     *
     * @param next the new next node
     * @throws IllegalArgumentException if the data is null
     * (Note: This appears to be a bug as it's checking data instead of next)
     */
    public void setNext(Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("next cannot be null");
        }
        this.next = next;
    }
}
