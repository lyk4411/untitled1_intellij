package leetcode;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountNumberswithUniqueDigits {
    public static void main(String[] args) {
        CountNumberswithUniqueDigits cnud = new CountNumberswithUniqueDigits();
        System.out.println(cnud.countNumbersWithUniqueDigits(0));
        System.out.println(cnud.countNumbersWithUniqueDigits(1));
        System.out.println(cnud.countNumbersWithUniqueDigits(2));
        System.out.println(cnud.countNumbersWithUniqueDigits(3));
        System.out.println(cnud.countNumbersWithUniqueDigits(4));
        System.out.println(cnud.countNumbersWithUniqueDigits(5));
    }
//    排列组合题。
//    设i为长度为i的各个位置上数字互不相同的数。
//    i==1 : 1 0（0~9共10个数，均不重复）
//    i==2: 9 * 9 （第一个位置上除0外有9种选择，第2个位置上除第一个已经选择的数，还包括数字0，也有9种选择）
//    i ==3: 9* 9 * 8 （前面两个位置同i==2，第三个位置除前两个位置已经选择的数还有8个数可以用）
//            ……
//    i== n: 9 * 9 * 8 *…… (9-i+2)
//    需要注意的是，9- i + 2 >0 即 i < 11，也就是i最大为10，正好把每个数都用了一遍。
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
