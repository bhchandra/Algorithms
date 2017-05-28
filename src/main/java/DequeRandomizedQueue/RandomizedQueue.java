package DequeRandomizedQueue;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author MITRA
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] s;
    private int count = 0;

    /**
     * Constructs an empty randomized queue
     */
    public RandomizedQueue() {
        s = (Item[]) new Object[2];
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
     * adds the item to the queue
     *
     * @param item
     */
    public void enqueue(Item item) {
        verify(item);
        if (count == s.length) {
            resize(2 * s.length);
        }
        s[count++] = item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < count; i++) {
            temp[i] = s[i];
        }
        s = temp;
    }

    /**
     * removes and returns a random item
     *
     * @return item
     */
    public Item dequeue() {
        checkEmpty();
        int random = StdRandom.uniform(count);
        Item temp = s[random];
        s[random] = s[count - 1];
        s[count] = null;
        count--;
//        for (int i = 0; i < count; i++) {
//              System.out.printf("%d-", s[i]);
//            }
//        System.out.println("");
        return temp;
    }

    /**
     * returns (but does not remove) a random item
     *
     * @return item
     */
    public Item sample() {
        checkEmpty();
        int random = StdRandom.uniform(count);
        return s[random];
    }

    private void checkEmpty() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("You can't remove an Item from an empty uque");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private void verify(Item item) {
        if (item == null) {
            throw new NullPointerException("Do not add null values to the Queue");
        }
    }

    private class QueueIterator implements Iterator<Item> {

        private int size;
        private Item[] copy;

        public QueueIterator() {
            size = count;
            copy = (Item[]) new Object[size];
            copyFromOriginal(copy, s);
        }

        private void copyFromOriginal(Item[] copy, Item[] s) {
            for (int i = 0; i < size; i++) {
                copy[i] = s[i];
            }
//            System.out.println("Copied Array: ");
//            for(int j = 0; j < size; j++){
//                System.out.printf("%d-", copy[j]);
//            }
//            System.out.println("");
        }

        @Override
        public boolean hasNext() {
            return size != 0;
        }

        @Override
        public Item next() {
            if (size == 0) {
                throw new NoSuchElementException("You can't remove an Item from an empty uque");
            }
            int random = StdRandom.uniform(size);
//            System.out.println("size: " + size + "random :" +random);
            Item tempItem = copy[random];
//            System.out.println(copy.length);
            copy[random] = copy[size - 1];
            copy[size - 1] = null;
            size--;
            /**
             * shrink size of array if necessary
             */
            if (size > 0 && size == s.length / 4) {
                resize(s.length / 2);
            }
            return tempItem;
        }

        @Override
        public void remove() {
            throw new NoSuchElementException();
        }

        private void resize(int capacity) {
            Item[] tempArray = (Item[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                tempArray[i] = copy[i];
            }
            copy = tempArray;
        }

    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(5);
        rq.enqueue(100);
        rq.enqueue(101);
        rq.enqueue(22);
        rq.enqueue(33);
        System.out.println("size :" + rq.size());
        System.out.println("deque: " + rq.dequeue());
        System.out.println("size :" + rq.size());
        System.out.println("deque :" + rq.dequeue());
        System.out.println("size :" + rq.size());
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
        System.out.println("size :" + rq.size());
        
//        Iterator<Integer> it = rq.iterator();
//        System.out.println(it.hasNext());
//        System.out.println(it.next());
        for (Integer x : rq) {
            System.out.printf("%d-", x);
        }

    }
}
