import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and
 * removing items from either the front or the back of the data structure.
 *
 * @param <Item> type of objects
 */
public class Deque<Item> implements Iterable<Item> {
    /**
     * The first node of deque
     */
    private Node first;

    /**
     * The last node of deque
     */
    private Node last;

    /**
     * Number of items on the deque
     */
    private int size;

    /**
     * Node
     */
    private class Node {
        /**
         * Node's item
         */
        Item item;

        /**
         * Next node
         */
        Node next;

        /**
         * Previous node
         */
        Node prev;
    }

    /**
     * Construct an empty deque
     */
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return is the deque empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return return the number of items on the deque
     */
    public int size() {
        return size;
    }

    /**
     * Add the item to the front
     *
     * @param item item
     */
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("the item can't be null");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst == null) last = first;
        else oldFirst.prev = first;
        size++;
    }

    /**
     * Add the item to the end
     *
     * @param item item
     */
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("the item can't be null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    /**
     * Remove and return the item from the front
     *
     * @return item
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("the deque is empty");
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        else first.prev = null;
        size--;
        return item;
    }

    /**
     * Remove and return the item from the end
     *
     * @return item
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("the deque is empty");
        Item item = last.item;
        last = last.prev;
        if (last == null) first = null;
        else last.next = null;
        size--;
        return item;
    }

    /**
     * Return an iterator over items in order from front to end
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("method unsupported for deque's iterator");
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException("no more items in iteration");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit testing
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        System.exit(0);
    }
}
