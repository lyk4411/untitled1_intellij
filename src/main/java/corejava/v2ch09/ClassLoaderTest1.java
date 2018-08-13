package corejava.v2ch09;

/**
 * Created by lyk on 2018-8-13.
 * Package name: corejava.v2ch09
 * Porject name: untitled1
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoaderA=new MyClassLoader();
        Object objA=myLoaderA.loadClass("corejava.v2ch09.JavaBean").newInstance();
        System.out.println(objA.getClass());
        System.out.println(objA.getClass().getClassLoader());
    }
}
