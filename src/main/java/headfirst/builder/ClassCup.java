package headfirst.builder;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.builder
 * Porject name: untitled1
 */

public class ClassCup extends Builder {

    @Override
    public void buildString() {
        cup.setString("生产绳子...");
        System.out.println("生产绳子...");
    }

    @Override
    public void buildCap() {
        cup.setCap("生产帽子...");
        System.out.println("生产帽子...");
    }

    @Override
    public void buildCupBody() {
        cup.setCupBody("生产杯体...");
        System.out.println("生产杯体...");
    }


}