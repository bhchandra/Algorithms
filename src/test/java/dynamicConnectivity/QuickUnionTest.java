package dynamicConnectivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MITRA
 */
public class QuickUnionTest {

    public QuickUnionTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isConnected method, of class QuickUnion. isConnected should
     * return false.
     */
    @Test
    public void test_IsConnected_false() {
        System.out.println("isConnected");
        int p = 1;
        int q = 2;
        UnionFind instance = new QuickUnion(100);
        boolean expResult = false;
        boolean result = instance.isConnected(p, q);
        assertEquals(expResult, result);
    }

    /**
     * Test of isConnected method, of class QuickUnion. isConnected should
     * return true.
     */
    @Test
    public void test_IsConnected_true() {
        System.out.println("isConnected");
        int p = 2;
        int q = 3;
        UnionFind instance = new QuickUnion(100);
        instance.unionOf(p, q);
        boolean expResult = true;
        boolean result = instance.isConnected(p, q);
        assertEquals(expResult, result);
    }

    /**
     * Test of unionOf method, of class QuickUnion.
     */
    @Test
    public void test_UnionOf_simple() {
        System.out.println("unionOf");
        int p = 11;
        int q = 99;
        UnionFind instance = new QuickUnion(100);
        instance.unionOf(p, q);
        assertEquals(true, instance.isConnected(p, q));

    }

    @Test
    public void test_UnionOf_complex() {
        System.out.println("unionOf");
        UnionFind instance = new QuickFind(100);
        instance.unionOf(14, 15);
        instance.unionOf(15, 30);
        instance.unionOf(77, 38);
        int p = 91;
        int q = 30;
        assertEquals(false, instance.isConnected(p, q));
        instance.unionOf(p, 14);
        assertEquals(true, instance.isConnected(p, 14));
        assertEquals(true, instance.isConnected(p, 15));
        assertEquals(false, instance.isConnected(p, 77));
        assertEquals(false, instance.isConnected(p, 38));
    }

}
