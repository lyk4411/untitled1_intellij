package corejava.v2ch05;

/**
 * Created by lyk on 2018-8-9.
 * Package name: corejava.v2ch05
 * Porject name: untitled1
 */
public class ListResourceBundleDemo {
    public static void main(String[] args) {

        // create a new MyResources instance
        MyResources mr = new MyResources();

        // print the string for key hello
        System.out.println("" + mr.getString("hello"));
    }
}
