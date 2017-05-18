package dynamicConnectivity;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 *
 * @author MITRA
 *
 * QuickFind algorithm has an expensive Union operation.
 * Union = O(n)
 * Find = O(1)
 * N union commands on N objects = O(N^2)
 */
public class QuickFind implements UnionFind {

    private int[] elements;

    /**
     * Constructor
     *
     * @param noElements
     */
    public QuickFind(int noElements) {
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
        return elements[p] == elements[q];
    }

    /**
     * performs a union of the two elements p and q, changes the index of p to
     * the index of q , and all the indexes of elements belonging to group as p
     * are changed to the index of q
     *
     * @param p, the first element
     * @param q , the second element
     */
    @Override
    public void unionOf(int p, int q) {
        int indexP = elements[p];
        int indexQ = elements[q];

        IntConsumer changeIndexOfPConnected = i -> { if (elements[i] == indexP) {elements[i] = indexQ;}};

        IntStream.range(0, elements.length).forEach(changeIndexOfPConnected);

    }

}
