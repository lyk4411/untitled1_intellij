package headfirst.builder;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.builder
 * Porject name: untitled1
 */

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void create() {
        builder.buildString();
        builder.buildCap();
        builder.buildCupBody();
        builder.getResult().show();
    }

    public static void main(String[] args) {
        Director d = new Director(new ClassCup());
        d.create();
    }

}