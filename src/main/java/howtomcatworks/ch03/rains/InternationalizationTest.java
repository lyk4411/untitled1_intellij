package howtomcatworks.ch03.rains;

import org.apache.catalina.util.StringManager;

import java.util.Locale;

/**
 * Created by lyk on 2019-3-12.
 * Package name: howtomcatworks.ch03.rains
 * Porject name: untitled1
 */
public class InternationalizationTest {
    public static void main(String[] args) {
//        Locale.setDefault(Locale.ENGLISH);
//        StringManager manager = StringManager.getManager("howtomcatworks.ch03.rains");
//        System.out.println(manager.getString("theme"));

        System.out.println(System.getProperty("user.dir"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        Locale.setDefault(Locale.JAPANESE);
        StringManager manager1 = StringManager.getManager("howtomcatworks.ch03.rains");
        System.out.println(manager1.getString("theme"));


    }
}
