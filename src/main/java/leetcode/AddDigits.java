package leetcode;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(1001));
    }
//If an integer is like 100a+10b+c,
// then (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9
    public int addDigits(int num) {
        return num==0?0:(num%9==0?9:(num%9));

//        while (num / 10 > 0) {
//            int sum = 0;
//            while (num > 0) {
//                sum += num % 10;
//                num /= 10;
//            }
//            num = sum;
//        }
//        return num;
    }
}
