package headfirst.templatemethod.template;

/**
 * Created by lyk on 2017/9/28.
 * Package name: headfirst.templatemethod.template
 * Porject name: untitled1
 */
public class App {
    public static void main(String[] args) {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
    }
}
