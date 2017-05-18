package dynamicConnectivity;

import java.util.stream.IntStream;

/**
 *
 * @author MITRA
 */
public class QuickUnion implements UnionFind {

    private int[] elements;

    /**
     * Constructor
     *
     * @param noElements
     */
    public QuickUnion(int noElements) {
        elements = new int[noElements];
        IntStream.range(0, noElements).forEach(i -> elements[i] = i);
    }
    
    /**
     * Checks if p and q are connected
     * 
     * @param p
     * @param q
     * @return true if connected, else false
     */
    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
    
    /**
     * Performs a union of the two elements p and q,
     * by changing the value at [root of p] equal to root of q. 
     * @param p
     * @param q 
     */
    @Override
    public void unionOf(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        elements[rootP] = rootQ;
    }
    
    /**
     * Calculates the root of the element x
     * 
     * @param x, an element 
     * @return the root of element x
     */
    private int root(int x) {

        int value = elements[x];

        if (value == x) {
            return x;
        }

        while (value != elements[x]) {
            x = value;
            value = elements[x];
        }
        return x;
    }

}
