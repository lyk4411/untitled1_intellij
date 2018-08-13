package corejava.v2ch09;

/**
 * Created by lyk on 2018-8-13.
 * Package name: corejava.v2ch09
 * Porject name: untitled1
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoaderA=new MyClassLoader1();
        ClassLoader myLoaderB=new MyClassLoader1();
        Object objA=myLoaderA.loadClass("corejava.v2ch09.JavaBean").newInstance();
        Object objB=myLoaderB.loadClass("corejava.v2ch09.JavaBean").newInstance();
        System.out.println(objA.getClass().getClassLoader()==objB.getClass().getClassLoader());
        System.out.println(objA.getClass()==objB.getClass());

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
