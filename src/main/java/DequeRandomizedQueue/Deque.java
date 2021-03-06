package DequeRandomizedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * A double-ended queue or deque is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the
 * data structure.
 *
 * @author MITRA
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int count = 0;

    private class Node<Item> {

        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    /**
     * constructs an empty deque
     */
    public Deque() {
    }

    /**
     * checks if the deque is empty or not
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * returns the number of items on the deque
     *
     * @return size in int
     */
    public int size() {

        return count;
    }

    /**
     * adds the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {
        verify(item);
        if (isEmpty()) {
            first = new Node<>();
            first.item = item;
            last = first;
        } else {
            Node<Item> current = first;
            first = new Node<>();
            first.item = item;
            first.next = current;
            first.prev = null;
            current.prev = first;
        }
        ++count;
    }

    /**
     * adds the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {
        verify(item);
        if (isEmpty()) {
            last = new Node<>();
            last.item = item;
            first = last;
        } else {
            Node<Item> current = last;
            last = new Node<>();
            last.item = item;
            last.prev = current;
            last.next = null;
            current.next = last;
        }
        ++count;
    }

    /**
     * remove and return the item from the front
     *
     * @return removed item
     */
    public Item removeFirst() {
        Node<Item> current = null;
        if (isEmpty()) {
            throw new NoSuchElementException("You can't remove an Item from an empty Deque");
        } else if (count == 1) {
            Item item = first.item;
            first = null;
            --count;
            return item;
        } else {
            current = first;
            first = current.next;
            first.prev = null;
        }
        --count;
        return current.item;
    }

    /**
     * removes and returns the item from the end
     *
     * @return removed item
     */
    public Item removeLast() {
        Node<Item> current;
        if (isEmpty()) {
            throw new NoSuchElementException("You can't remove an Item from an empty Deque");
        } else if (count == 1) {
            Item item = last.item;
            last = null;
            --count;
            return item;

        } else {
            current = last;
            last = current.prev;
            last.next = null;
        }
        --count;
        return current.item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ForwareIterator();
    }

    private class ForwareIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void verify(Item item) {
        if (item == null) {
            throw new NullPointerException("Do not add null values to the Deque");
        }
    }

    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();

        dq.addFirst(1);
        printIt(dq);
        dq.removeFirst();
        printIt(dq);
        dq.addFirst(2);
        printIt(dq);
    }

    private static void printIt(Deque<Integer> dq) {
        for(Integer x: dq){
            System.out.println(x);
        }
    }

}
