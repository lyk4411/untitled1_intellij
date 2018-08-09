package corejava.v2ch05;

/**
 * Created by lyk on 2018-8-9.
 * Package name: corejava.v2ch05
 * Porject name: untitled1
 */

import java.util.Date;
import java.util.ListResourceBundle;

public class Numbers_eo extends ListResourceBundle {

    private static final Object[][] TRANSLATIONS = {
            {"sum-of-numbers", "%s plus %s estas %s"},
            {"one", "unu"},
            {"two", "du"},
            {"three", "tri"},
            {"date",new Date()}
    };

    @Override
    protected Object[][] getContents() {
        return TRANSLATIONS;
    }
}