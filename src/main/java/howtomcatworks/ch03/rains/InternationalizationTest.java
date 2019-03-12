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
        Locale.setDefault(Locale.ENGLISH);
        StringManager manager = StringManager.getManager("rains");
        System.out.println(manager.getString("theme"));

//        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
//        System.out.println(System.getProperty("user.dir"));
        Locale.setDefault(Locale.JAPANESE);
        StringManager manager1 = StringManager.getManager("rains");
        System.out.println(manager == manager1);
        System.out.println(manager1.getString("theme"));


    }
}
