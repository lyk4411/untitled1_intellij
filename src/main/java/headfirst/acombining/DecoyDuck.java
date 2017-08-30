package headfirst.acombining;

/**
 * Created by lyk on 2017/8/30.
 * Package name: headfirst.acombining
 * Porject name: untitled1
 */


public class DecoyDuck implements Quackable {
    public void quack() {
        System.out.println("<< Silence >>");
    }


    public String toString() {
        return "Decoy Duck";
    }
}
