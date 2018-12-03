package learnJVM.ch13;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by lyk on 2018-12-3.
 * Package name: learnJVM.ch13
 * Porject name: untitled1
 */
public class methodhanle1 {
    public static void main(String[] args) {


        Object rcvr = "a";
        try {
            MethodType mt = MethodType.methodType(int.class); // 方法签名
            MethodHandles.Lookup l = MethodHandles.lookup(); // 调用者，也就是当前类。调用者决定有没有权限能访问到方法
            MethodHandle mh = l.findVirtual(rcvr.getClass(), "hashCode", mt); //分别是定义方法的类，方法名，签名

            int ret;
            try {
                ret = (int) mh.invoke(rcvr); // 代码，第一个参数就是接收者
                System.out.println(ret);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}
