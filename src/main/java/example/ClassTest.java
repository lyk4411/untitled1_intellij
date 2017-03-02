package example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */

public class ClassTest {
    public static void main(String[] args) throws Exception {
        ParameterizedType type = (ParameterizedType)
                Bar.class.getGenericSuperclass();
        System.out.println(type.getActualTypeArguments()[0]);

        ParameterizedType fieldType = (ParameterizedType)
                Foo.class.getField("children").getGenericType();
        System.out.println(fieldType.getActualTypeArguments()[0]);

        ParameterizedType paramType = (ParameterizedType)
                Foo.class.getMethod("foo", List.class)
                        .getGenericParameterTypes()[0];
        System.out.println(paramType.getActualTypeArguments()[0]);

        System.out.println(Foo.class.getTypeParameters()[0]
                .getBounds()[0]);
    }

    class Foo<E extends CharSequence> {
        public List<Bar> children = new ArrayList<Bar>();
        public List<StringBuilder> foo(List<String> foo) {return null; }
        public void bar(List<? extends String> param) {}
    }

    class Bar extends Foo<String> {}
}