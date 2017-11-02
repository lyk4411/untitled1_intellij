package example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lyk on 2017-11-2.
 * Package name: example
 * Porject name: untitled1
 */
public class GetFileName {
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        for(File a:files){
            if(a.isFile()) {
                String[] ns = a.list();
                if(ns != null) {
                    fileName.addAll(Arrays.asList(ns));
                }
            }
        }
//        if(names != null)
//            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    public static void main(String[] args)
    {
        String [] fileName = getFileName("F:\\cfets风险管理部\\审计与检查\\AuditandInspect\\2017年审计\\2017年专项审计\\专项审计资料提供");
        for(String name:fileName)
        {
            System.out.println(name);
        }
        System.out.println("--------------------------------");
        ArrayList<String> listFileName = new ArrayList<String>();
        getAllFileName("F:\\cfets风险管理部\\审计与检查\\AuditandInspect\\2017年审计\\2017年专项审计\\专项审计资料提供",listFileName);
        for(String name:listFileName)
        {
            System.out.println(name);
        }

    }
}
