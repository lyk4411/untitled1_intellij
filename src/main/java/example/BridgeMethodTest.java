package example;

/**
 * Created by lyk on 2017/3/2.
 * Package name: example
 * Porject name: untitled1
 */



public class BridgeMethodTest {

    public static void main(String[] args) throws Exception {
        SuperClass<String> superClass = new SubClass();
        System.out.println(superClass.method("abc123"));// 调用的是实际的方法
        //System.out.println(superClass.method(new Object()));// 调用的是桥接方法
    }
}

interface SuperClass<T> {

    T method(T param);

}
class SubClass implements SuperClass<String> {
    public String method(String param) {
        return param;
    }
}
