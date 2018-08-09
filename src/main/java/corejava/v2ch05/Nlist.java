package corejava.v2ch05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by lyk on 2018-8-9.
 * Package name: corejava.v2ch05
 * Porject name: untitled1
 */
public class Nlist {
    private static final String BUNDLE_NAME
            = "corejava.v2ch05.Numbers";

    public static void main(String[] args) {
        ResourceBundle bundle
                = ResourceBundle.getBundle(BUNDLE_NAME, new Locale("eo"));

        translate(bundle, "one");
        translate(bundle, "two");
        translate(bundle, "three");
        System.out.println("=========================");
        System.out.printf(
                bundle.getString("sum-of-numbers"),
                bundle.getString("one"),
                bundle.getString("two"),
                bundle.getString("three"));
        System.out.println();
        System.out.println("=========================");
        System.out.printf(String.valueOf(bundle.getObject("date")));
    }

    static void translate(ResourceBundle bundle, String key) {
        System.out.printf("'%s' in Esperanto: %s%n",
                key, bundle.getString(key));
    }
}
