package learnJVM.ch07;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lyk on 2018-11-8.
 * Package name: learnJVM.ch07
 * Porject name: untitled1
 */

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("learnJVM.ch07.ClassLoaderTest").newInstance();
        Object obj1 = new ClassLoaderTest();
        System.out.println(obj.getClass());
        System.out.println(obj1.getClass());
        System.out.println(obj instanceof learnJVM.ch07.ClassLoaderTest);
        System.out.println(obj1 instanceof learnJVM.ch07.ClassLoaderTest);
    }
}

