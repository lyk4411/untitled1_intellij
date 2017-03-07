package leetcode;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        ExcelSheetColumnNumber escn =new ExcelSheetColumnNumber();
        System.out.println(escn.titleToNumber("AAABCD"));
    }
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
