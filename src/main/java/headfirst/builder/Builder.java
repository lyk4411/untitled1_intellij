package headfirst.builder;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.builder
 * Porject name: untitled1
 */

public abstract class  Builder {

    protected Cup cup = new Cup();

    public abstract void buildString();

    public abstract void buildCap();

    public abstract void buildCupBody();

    public  Cup getResult() {
        return cup;
    }

}