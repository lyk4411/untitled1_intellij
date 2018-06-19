package example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
/**
 * Created by lyk on 2017-11-2.
 * Package name: example
 * Porject name: untitled1
 */
public class ReadFile {
    public ReadFile() {
    }
    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                //System.out.println("文件");
                //System.out.println("path=" + file.getPath());
                //System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("" + file.getName());

            } else if (file.isDirectory()) {
                //System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                  //      System.out.println("path=" + readfile.getPath());
                   //     System.out.println("absolutepath="
                    //            + readfile.getAbsolutePath());
                        System.out.println("" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }


    public static void main(String[] args) {
        try {
            readfile("F:\\cfets风险管理部\\审计与检查\\AuditandInspect\\2018年安全运行监督检查\\检查材料\\调阅材料\\中汇公司");
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        System.out.println("ok");
    }
}
