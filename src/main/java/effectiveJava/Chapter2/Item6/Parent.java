package effectiveJava.Chapter2.Item6;

/**
 * Created by lyk on 2019-1-18.
 * Package name: effectiveJava.Chapter2.Item6
 * Porject name: untitled1
 */

/**
 * chapter 2——终结守卫者
 * @ClassName: Parent
 * TODO
 * @author xingle
 * @date 2015-3-11 下午3:49:47
 */
public class Parent {

    public static void main(String[] args){
        doSth();
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO
     * @author xingle
     * @data 2015-3-11 下午3:51:02
     */
    private static void doSth() {
        Child c = new Child();
        System.out.println(c);
    }

    private final Object guardian = new Object(){

        @Override
        protected void finalize(){
            System.out.println("执行父类中匿名内部类--终结方法守卫者,重写的finalize()");
            // 在这里调用Parent重写的finalize即可在清理子类时调用父类自己的清理方法
            parentlFinalize();
        }
    };

    /**
     * TODO
     * @author xingle
     * @data 2015-3-11 下午3:55:10
     */
    protected void parentlFinalize() {
        System.out.println("执行父类自身的终结方法");
    }
}

class Child extends Parent {

    @Override
    protected void finalize() {
        System.out.println("执行子类finalize方法，注意，这里子类并没有调用super.finalize()");
        // 由于子类（忘记或者其他原因）没有调用super.finalize()
        // 使用终结方法守卫者可以保证子类执行finalize()时(没有调用super.finalize())，父类的清理方法仍旧调用
    }
}