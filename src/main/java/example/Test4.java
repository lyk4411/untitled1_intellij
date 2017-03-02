package example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by lyk on 2017/3/2.
 * Package name: example
 * Porject name: untitled1
 */
public class Test4 {
    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InvocationTargetException {
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        //arrayList3.add("aaa");
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3,"aaa");
        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }
    }
}