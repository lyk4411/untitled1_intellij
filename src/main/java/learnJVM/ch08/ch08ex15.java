package learnJVM.ch08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * Created by lyk on 2018-11-26.
 * Package name: learnJVM.ch08
 * Porject name: untitled1
 */
public class ch08ex15 {


    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                // 1.7
//                MethodType mt = MethodType.methodType(void.class);
//                MethodHandle mh = lookup().findSpecial(GrandFather.class,
//                        "thinking", mt, getClass());
//                mh.invoke(this);
                //1.8
                MethodType mt = MethodType.methodType(void.class);
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup)IMPL_LOOKUP.get(null);
                MethodHandle h1 = lkp.findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                h1.invoke(this);
                } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        (new ch08ex15().new Son()).thinking();
    }
}
