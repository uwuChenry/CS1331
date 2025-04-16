
public class Node<T>{
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        if (data == null) {
            throw new IllegalArgumentException("next cannot be null");
        }
        this.next = next;
    }

}
