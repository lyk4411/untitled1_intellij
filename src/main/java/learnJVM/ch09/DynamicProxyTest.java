package learnJVM.ch09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lyk on 2018-11-26.
 * Package name: learnJVM.ch09
 * Porject name: untitled1
 */

public class DynamicProxyTest {

    interface IHello {
        void sayHello();
        void sayWorld();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
        @Override
        public void sayWorld() {
            System.out.println("worldworldworldworldworldworldworldworld");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                    originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        System.out.println("=================");
        hello.sayWorld();

    }
}

