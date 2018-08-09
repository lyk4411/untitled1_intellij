package corejava.v2ch05;

/**
 * Created by lyk on 2018-8-9.
 * Package name: corejava.v2ch05
 * Porject name: untitled1
 */

import java.util.*;

// create a class that extends to ListResourceBundle
public class MyResources extends ListResourceBundle {

    // get contents must be implemented
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", "Hello World!"},
                {"bye", "Goodbye World!"},
                {"goodnight", "Goodnight World!"}
        };
    }
}
