package corejava.v2ch01.Serializable;

import java.io.*;

/**
 * Created by lyk on 2018-8-1.
 * Package name: corejava.v2ch01.Serializable
 * Porject name: untitled1
 */
public class SerSingleton implements Serializable {
    String name;

    private SerSingleton() {
        System.out.println("Singleton is creating");
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance() {
        return instance;
    }

    private Object readResolve(){
        System.out.println("read resolve");
        return instance;
    }

    public static void createString() {
        System.out.println("create string in singleton");
    }

    public static void main(String[] args) throws Exception {
        SerSingleton ss = new SerSingleton();
        ss.test();
    }
    public void test() throws Exception{
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("a.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();

        System.out.println(s1 == s);
        System.out.println(s1);
        System.out.println(s);
    }
}
