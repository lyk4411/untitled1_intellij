package learnJVM.ch09;

/**
 * Created by lyk on 2018-11-26.
 * Package name: learnJVM.ch09
 * Porject name: untitled1
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface HelloInterface {
     void say();
}
class HelloInterfaceImpl implements HelloInterface {
    @Override
    public void say() {
        System.out.println("Hello");
    }
}
class HelloDynamicProxy implements InvocationHandler{
    private Object target;
    /**
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    /**
     *
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result=null;
        System.out.println("BEGIN");

        result=method.invoke(target, args);
        System.out.println("END");
        return result;
    }
}
public class TestProxy {

    public static void main(String[] args) {
        HelloDynamicProxy proxy = new HelloDynamicProxy();
        HelloInterface helloProxy = (HelloInterface) proxy.bind(new HelloInterfaceImpl());
        helloProxy.say();
    }

}