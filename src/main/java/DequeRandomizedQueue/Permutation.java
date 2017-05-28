package DequeRandomizedQueue;

import edu.princeton.cs.algs4.StdIn;

/**
 *
 * @author MITRA
 */
public class Permutation {

    public static void main(String[] args) {
        final RandomizedQueue<String> rq = new RandomizedQueue<>();

        final int k = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            rq.enqueue(s);
        }

        int count = 0;
        for (String s : rq) {
            if (count == k) {
                break;
            }
            System.out.println(s);
            count++;
        }
    }
}
