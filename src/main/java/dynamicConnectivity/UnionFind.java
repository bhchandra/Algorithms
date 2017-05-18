package dynamicConnectivity;

/**
 *
 * @author MITRA
 */
public interface UnionFind {
 
    boolean isConnected(int p, int q);
    
    void unionOf(int p, int q);
    
}
