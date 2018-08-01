package corejava.v2ch01.Serializable;

import java.io.*;

/**
 * Created by lyk on 2018-8-1.
 * Package name: corejava.v2ch01.Serializable
 * Porject name: untitled1
 */

public class People implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 2659082826995480601L;
    private int age;
    private String name;

    People(int age,String name)
    {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void writeObject(ObjectOutputStream out)
    {
        System.out.println("BBBBBBBB？");
    }
    private void readObject(ObjectInputStream in)
    {
        System.out.println("AAAAAA？");
    }

    private Object readResolve()
    {
        return new People(20,"老子喜欢刚正面");
    }

    public static void main(String[] args) throws IOException {
        People p = new People(3,"abc");
        p.testOut01();
    }
    public void testOut01() throws FileNotFoundException, IOException
    {
        People p = new People(100,"老汉");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\temp01.txt"));
        out.writeObject(p);
        out.flush();
        out.close();
    }
}