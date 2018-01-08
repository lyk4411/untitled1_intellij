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
        assertEquals(9,Largest.largest(new int[]{9,8,7}));
        assertEquals(9,Largest.largest(new int[]{7,9,8}));
        assertEquals(-7,Largest.largest(new int[]{-7,-8,-9}));
        assertEquals(-7,Largest.largest(new int[]{-7,-99,-9}));

    }
}
