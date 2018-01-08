package JUnitLearn.ch03;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by lyk on 2018-1-8.
 * Package name: JUnitLearn.ch03
 * Porject name: untitled1
 */
public class TestClassComposite extends TestCase {
    public TestClassComposite(String method){
        super(method);
    }
    static public Test suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestClassOne.class);
        suite.addTest(TestClassTwo.suite());
        return suite;
    }
}
