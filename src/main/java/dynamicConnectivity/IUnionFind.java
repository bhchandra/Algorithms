package dynamicConnectivity;

/**
 *
 * @author MITRA
 */
public interface IUnionFind {
    
    /**
     * Returns the number of the component which P belong to
     * @param p 
     * @return the number of the component
     */
    int getComponent(int p);
    
    /**
     * Return true if p and Q are connected, else returns false
     * 
     * @param p, first int belonging to elements
     * @param q, second int belonging to elements
     * @return true or false
     */
    boolean isConnected(int p, int q);
    
    /**
     * Combines the components of p and q
     * 
     * @param p, first int belonging to elements
     * @param q, second int belonging to elements
     */
    void unionOf(int p, int q);
    
}
