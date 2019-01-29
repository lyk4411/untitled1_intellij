package effectiveJava.Chapter11.Item74;

import java.io.*;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item74
 * Porject name: untitled1
 */
public class SerializableTest {
    public static void main(String args[]) throws Exception{

        File file = new File("box.out");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        Box oldBox = new Box(10,20);
        out.writeObject(oldBox);
        out.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fis);
        Box newBox = (Box)in.readObject();
        in.close();
        System.out.println(newBox.toString());

    }
}
