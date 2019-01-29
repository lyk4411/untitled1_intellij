package effectiveJava.Chapter11.Item76;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item76
 * Porject name: untitled1
 */


import java.io.*;

public class ObjectInputStreamDemo {

    public static void main(String[] args) {

        String s = "Hello World";
        byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        try {

            // create a new file with an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("test.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file
            oout.writeObject(s);
            oout.writeObject(b);
            oout.flush();

            // create an ObjectInputStream for the file we created before
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("test.txt"));

            // read and print an object and cast it as string
            System.out.println("" + (String) ois.readObject());

            // read and print an object and cast it as string
            byte[] read = (byte[]) ois.readObject();
            String s2 = new String(read);
            System.out.println("" + s2);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}