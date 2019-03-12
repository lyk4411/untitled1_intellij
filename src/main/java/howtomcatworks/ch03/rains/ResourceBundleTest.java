package howtomcatworks.ch03.rains;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by lyk on 2019-3-12.
 * Package name: howtomcatworks.ch03.rains
 * Porject name: untitled1
 */

public class ResourceBundleTest {
    public static void main(String[] args) {
        // 指明包路径和文件名即可
        Locale.setDefault(Locale.JAPANESE);

        ResourceBundle resource = ResourceBundle.getBundle("LocalStrings");
        String driverName = resource.getString("database.driver");
        String url = resource.getString("database.url");
        Object[] array1 = new Object[]{"root"};
        Object[] array2 = new Object[]{"test"};
        // 取得字符串，直接格式化
        String user = MessageFormat.format(resource.getString("database.user"), new Object[]{"root"});
        String pass = MessageFormat.format(resource.getString("database.pass"), new Object[]{"test"});

        System.out.println(driverName + url + user + pass);//结果：com.mysql.jdbc.Drvierjdbc:mysql://localhost:3306:testroottest
    }
}