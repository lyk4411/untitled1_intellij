package learnJVM.ch13;

/**
 * Created by lyk on 2018-12-3.
 * Package name: learnJVM.ch13
 * Porject name: untitled1
 */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MyMethodHandle {

    @Override
    public String toString() {
        return super.toString() + "==MethodHandle";
    }

    public static void main(String[] args) throws Throwable{
        MyMethodHandle handle = new MyMethodHandle();
        MethodType methodType = MethodType.methodType(String.class);

        Lookup lookup = MethodHandles.lookup();

        MethodHandle methodHandle = lookup.findVirtual(MyMethodHandle.class, "toString", methodType);
        String toString = (String) methodHandle.invokeExact(handle);
        System.out.println("toString:" + toString);

        MethodHandle methodHandle2 = methodHandle.bindTo(handle);
        String toString2 = (String) methodHandle2.invokeWithArguments();
        System.out.println("toString2:" + toString2);

        // 得到当前Class的不同表示方法，最后一个最好。一般我们在静态上下文用SLF4J得到logger用。
        System.out.println(MethodHandle.class);
        System.out.println(handle.getClass());
        System.out.println(MethodHandles.lookup().lookupClass()); // like getClass()
    }

}