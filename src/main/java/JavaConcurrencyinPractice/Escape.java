package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2018-12-17.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */

public class Escape{
    private int thisCanBeEscape = 10;
    public Escape(){
        new InnerClass();
        thisCanBeEscape = 100;
    }

    private  class InnerClass {
        public InnerClass() {
            //这里可以在Escape对象完成构造前提前引用到Escape的private变量
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }



    public static void main(String[] args) {
        System.out.println(new Escape().thisCanBeEscape);

    }

}