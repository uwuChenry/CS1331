import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T>{
    private Node<T> next;

    public LinkedListIterator(LinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        this.next = list.getHead();
    }
    @Override
    public boolean hasNext() {
        return next != null;
    }
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
