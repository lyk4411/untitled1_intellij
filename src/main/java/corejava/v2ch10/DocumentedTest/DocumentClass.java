package corejava.v2ch10.DocumentedTest;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.DocumentedTest
 * Porject name: untitled1
 */



public class DocumentClass {
    /**
     * this is method of doSomething
     */
    @DocumentTest(hello = "yahaitt")
    public void doSomething()
    {
        System.out.println("do something");
    }

    /**
     * this is method of say
     */
    public void say()
    {
        System.out.println("say");
    }
}