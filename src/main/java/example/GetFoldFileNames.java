package example;

import java.io.File;

/**
 * Created by lyk on 2017-11-2.
 * Package name: example
 * Porject name: untitled1
 */
public class GetFoldFileNames {

    /**
     *
     * @author zdz8207
     */
    public static void main(String[] args) {
        getFileName();
    }

    public static void getFileName() {
        String path = "F:\\cfets风险管理部\\审计与检查\\AuditandInspect\\2017年审计\\2017年专项审计\\专项审计资料提供"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }
}
