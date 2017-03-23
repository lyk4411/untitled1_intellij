package leetcode;

/**
 * Created by lyk on 2017/3/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        System.out.println(esct.convertToTitle(1000));
        System.out.println(esct.convertToTitle(1));

    }
    public String convertToTitle(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }
}
