package example;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */


public class Manipulator<T extends  HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f(); //无法编译 找不到符号 f()
    }

    public static void main(String[] args) {
        HasF hasF  = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manipulate();

    }
}

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}