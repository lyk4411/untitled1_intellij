package corejava.v2ch09;

/**
 * Created by lyk on 2018-8-13.
 * Package name: corejava.v2ch09
 * Porject name: untitled1
 */

public class ClassLoaderTest {//测试类
    public static void main(String[] args) throws Exception{
        ClassLoader myLoaderA=new MyClassLoader();
        Object objA=myLoaderA.loadClass("corejava.v2ch09.JavaBean").newInstance();
        Object objB=new JavaBean();
        System.out.println(objA.getClass());
        System.out.println(objB.getClass());
        System.out.println(objA.getClass().getClassLoader());
        System.out.println(objB.getClass().getClassLoader());
        System.out.println(objA.getClass().equals(objB.getClass()));
    }
}