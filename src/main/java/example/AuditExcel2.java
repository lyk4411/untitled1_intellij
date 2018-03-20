package example;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

/**
 * Created by lyk on 2018-3-15.
 * Package name: example
 * Porject name: untitled1
 */
public class AuditExcel2 {
    public static void main(String[] args) throws IOException, WriteException, BiffException {
        String[] fileNames = new String[]{
                "1.10.2",
                "3.2.3",
                "3.5.1",
                "3.5.2",
                "3.6.1",
                "3.6.2",
                "3.7.3",
                "3.8.2",
                "4.2.2",
                "4.2.3",
                "4.2.4",
                "4.2.5",
                "4.3.4",
                "4.4.2",
                "4.4.6",
                "4.7.1",
                "6.1.3"
        };
        File xlsFile = new File("F:\\Users\\lyk\\IdeaProjects" +
                "\\untitled1\\excel2\\itaudit_que6.xls");
        // 获得工作簿对象
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(xlsFile);
            // 获得所有工作表
            Sheet[] sheets = workbook.getSheets();
            // 遍历工作表
            if (sheets != null) {
                for (Sheet sheet : sheets) {
                    for(int i = 0;  i < fileNames.length;i++){
                        File newXlsFile = new File("F:\\Users\\lyk\\IdeaProjects\\untitled1\\excel2\\"
                                + fileNames[i] + ".xls");
                        WritableWorkbook newworkbook = Workbook.createWorkbook(newXlsFile);
                        WritableSheet newsheet = newworkbook.createSheet("问题单", 0);
                        newsheet.addCell(new Label(0,0,"审计测试结果"));
                        newsheet.addCell(new Label(1,0,"审计发现整改建议"));
                        newsheet.addCell(new Label(2,0,"系统"));
                        newsheet.addCell(new Label(3,0,"关键字"));
                        newsheet.addCell(new Label(4,0,"联系人"));
                        newsheet.addCell(new Label(5,0,"问题部门"));
                        newsheet.addCell(new Label(6,0,"问题级别"));
                        newsheet.addCell(new Label(7,0,"问题状"));
                        newsheet.addCell(new Label(8,0,"跟踪情况记录"));
                        newsheet.addCell(new Label(9,0,"备注"));
                        newsheet.addCell(new Label(10,0,"问题单号"));

                        newsheet.addCell(new Label(0,1,sheet.getCell(0, i+1).getContents()));
                        newsheet.addCell(new Label(1,1,sheet.getCell(1, i+1).getContents()));
                        newsheet.addCell(new Label(2,1,sheet.getCell(2, i+1).getContents()));
                        newsheet.addCell(new Label(3,1,sheet.getCell(3, i+1).getContents()));
                        newsheet.addCell(new Label(4,1,sheet.getCell(4, i+1).getContents()));
                        newsheet.addCell(new Label(5,1,sheet.getCell(5, i+1).getContents()));
                        newsheet.addCell(new Label(6,1,sheet.getCell(6, i+1).getContents()));
                        newsheet.addCell(new Label(7,1,sheet.getCell(7, i+1).getContents()));
                        newsheet.addCell(new Label(8,1,sheet.getCell(8, i+1).getContents()));
                        newsheet.addCell(new Label(9,1,sheet.getCell(9, i+1).getContents()));
                        newsheet.addCell(new Label(10,1,sheet.getCell(10, i+1).getContents()));



                        WritableSheet newsheet1 = newworkbook.createSheet("跟踪单", 1);
                        newsheet1.addCell(new Label(0,0,"整改措施"));
                        newsheet1.addCell(new Label(1,0,"整改责任部门"));
                        newsheet1.addCell(new Label(2,0,"整改责任人"));
                        newsheet1.addCell(new Label(3,0,"预计整改完成时间"));
                        newsheet1.addCell(new Label(4,0,"整改结果"));
                        newsheet1.addCell(new Label(5,0,"实际整改完成时间"));
                        newsheet1.addCell(new Label(6,0,"备注"));
                        newsheet1.addCell(new Label(7,0,"关联序号"));

                        newworkbook.write();
                        newworkbook.close();
//                    // 获得行数
//                    int rows = sheet.getRows();
//                    // 获得列数
//                    int cols = sheet.getColumns();
//                    // 读取数据
//                    for (int row = 0; row < rows; row++) {
//                        for (int col = 0; col < cols; col++) {
//                            System.out.printf("%10s", sheet.getCell(col, row)
//                                    .getContents());
//                        }
//                        System.out.println();
                    }
                }
            }
        }catch(BiffException e){
            e.printStackTrace();
        }finally{
            workbook.close();
        }
    }

//        for(int i=0;  i<str1.length;i++){
//            File xlsFile = new File("F:\\Users\\lyk\\IdeaProjects\\untitled1\\excel\\"
//                    + fileNames[i] + ".xls");
//            WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
//            WritableSheet sheet = workbook.createSheet("sheet1", 0);
//
//            sheet.addCell(new Label(0,0,"审计测试结果"));
//            sheet.addCell(new Label(1,0,"审计发现整改建议"));
//            sheet.addCell(new Label(2,0,"系统"));
//            sheet.addCell(new Label(3,0,"关键字"));
//            sheet.addCell(new Label(4,0,"联系人"));
//            sheet.addCell(new Label(5,0,"问题部门"));
//            sheet.addCell(new Label(6,0,"问题级别"));
//            sheet.addCell(new Label(7,0,"问题状"));
//            sheet.addCell(new Label(8,0,"跟踪情况记录"));
//            sheet.addCell(new Label(9,0,"备注"));
//            sheet.addCell(new Label(10,0,"问题单号"));
//
//            sheet.addCell(new Label(0,1,str1[i]));
//            sheet.addCell(new Label(1,1,str2[i]));
//            sheet.addCell(new Label(2,1,"N/A"));
//            sheet.addCell(new Label(3,1,"2017年全面审计"));
//            sheet.addCell(new Label(4,1,"陈晓跃"));
//            sheet.addCell(new Label(5,1,str3[i]));
//            sheet.addCell(new Label(6,1,"轻微"));
//            sheet.addCell(new Label(7,1,"发现问题"));
//            sheet.addCell(new Label(8,1,""));
//            sheet.addCell(new Label(9,1,"无"));
//            sheet.addCell(new Label(10,1,""));
//
//            workbook.write();
//            workbook.close();
//
//        }
//    }
}
