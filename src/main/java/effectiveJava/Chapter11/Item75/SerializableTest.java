package effectiveJava.Chapter11.Item75;

import java.io.*;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item75
 * Porject name: untitled1


 import java.io.*;

 /**
 * Author : Slogen
 * AddTime : 17/4/30
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        TestObject testObject = new TestObject();
        oos.writeObject(testObject);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestObject deTest = (TestObject) ois.readObject();
        System.out.println(deTest.testValue);
        System.out.println(deTest.parentValue);
        System.out.println(deTest.innerObject.innerValue);
    }
}

class Parent implements Serializable {

    private static final long serialVersionUID = -4963266899668807475L;

    public int parentValue = 100;
}

class InnerObject implements Serializable {

    private static final long serialVersionUID = 5704957411985783570L;

    public int innerValue = 200;
}

class TestObject extends Parent implements Serializable {

    private static final long serialVersionUID = -3186721026267206914L;

    public int testValue = 300;

    public InnerObject innerObject = new InnerObject();
}