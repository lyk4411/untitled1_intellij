package learnJVM.ch12;

/**
 * Created by lyk on 2018-11-28.
 * Package name: learnJVM.ch12
 * Porject name: untitled1
 */

class Glyph {
    void draw() { //没有执行
        System.out.println("Glyph.draw()");
    }
    Glyph() {     //3，默认调用
        System.out.println("Glyph() before draw()");
        draw();   //父类构造器作为子类构造器执行前的默认执行，此时父构造器内执行的方法是子类的重写方法。
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;  //5，初始化变量

    RoundGlyph(int r) {//2，首先调用父类构造器（并且默认是无参构造器）
        radius = r;    //6，赋值执行
        System.out.println("RoundGlyph.RoundGlyph(). radius = " + radius);
    }

    void draw() {  //4，在父构造器被调用，此时该类（子类）还没被初始化，所以实例变量的值为默认值。
        System.out.println("RoundGlyph.draw(). radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);//1，首先执行
    }
}