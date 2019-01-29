package effectiveJava.Chapter11.Item74;

import java.io.Serializable;

/**
 * Created by lyk on 2019-1-29.
 * Package name: effectiveJava.Chapter11.Item74
 * Porject name: untitled1
 */

public class Box implements Serializable {

    private int width;
    private int height;

    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Child{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}