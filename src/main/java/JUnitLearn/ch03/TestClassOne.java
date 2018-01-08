package JUnitLearn.ch03;

import junit.framework.TestCase;

/**
 * Created by lyk on 2018-1-8.
 * Package name: JUnitLearn.ch03
 * Porject name: untitled1
 */
public class TestClassOne extends TestCase {
    public TestClassOne(String method){
        super(method);
    }
    public void testAddition(){
        assertEquals(4,2 + 2);
    }
    public void testSubtraction(){
        assertEquals(0,2 - 2);
    }

//    public static Test suite(){
//
//    }
}
