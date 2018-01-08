package JUnitLearn.ch02;

import junit.framework.TestCase;

/**
 * Created by lyk on 2018-1-8.
 * Package name: JUnitLearn.ch02
 * Porject name: untitled1
 */
public class TestLargest extends TestCase {
    public TestLargest(String name){
        super(name);
    }
    public void testSimple(){
        assertEquals(9,Largest.largest(new int[]{7,8,9}));
    }
    public void testNegative(){
        assertEquals(-7,Largest.largest(new int[]{-7,-8,-9}));
        assertEquals(-7,Largest.largest(new int[]{-7,-99,-9}));
    }
    public void testOrder(){
        assertEquals(9,Largest.largest(new int[]{9,8,7}));
        assertEquals(9,Largest.largest(new int[]{7,9,8}));
        assertEquals(9,Largest.largest(new int[]{7,8,9}));

    }
    public void testDups(){
        assertEquals(9,Largest.largest(new int[]{9,8,7,9,8,7}));
    }
    public void testOne(){
        assertEquals(1,Largest.largest(new int[]{1}));
    }
    public void testSimple2(){
        int[] arr = new int[3];
        arr[0]=7;
        arr[1]=8;
        arr[2]=9;
        assertEquals(9,Largest.largest(arr));
    }
    public void testEmpty(){
        try {
            Largest.largest(new int[]{});
            fail("Should have thrown an exception.");
        } catch (RuntimeException e){
            assertTrue(true);
        }
    }
}
