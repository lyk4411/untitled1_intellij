package JUnitLearn.ch03;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by lyk on 2018-1-8.
 * Package name: JUnitLearn.ch03
 * Porject name: untitled1
 */
public class TestClassTwo  extends TestCase{
    public TestClassTwo(String method){
        super(method);
    }
    public void testLongRunner(){
        assertEquals(10,2);
    }
    public void testShortTest(){
        assertEquals(2,2);
    }
    public void testAnotherShortTest(){
        assertEquals(2,2);
    }

    public static Test suite(){
        TestSuite suite = new TestSuite();
        //suite.addTest(new TestClassTwo("testLongRunner"));
        suite.addTest(new TestClassTwo("testShortTest"));
        suite.addTest(new TestClassTwo("testAnotherShortTest"));
        return  suite;
    }
}
