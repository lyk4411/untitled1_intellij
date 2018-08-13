package corejava.v2ch09;

/**
 * Created by lyk on 2018-8-13.
 * Package name: corejava.v2ch09
 * Porject name: untitled1
 */
public class MyClassLoader1  extends ClassLoader{
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        return super.loadClass(name);
    }
}
