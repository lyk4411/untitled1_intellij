package leetcode;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumofTwoIntegers {
    public static void main(String[] args) {
        SumofTwoIntegers sti = new SumofTwoIntegers();
        System.out.println(sti.getSum(11,21));
    }
//    这道题让我们实现两数相加，但是不能用加号或者其他什么数学运算符号，
//    那么我们只能回归计算机运算的本质，位操作Bit Manipulation，我们在
//    做加法运算的时候，每位相加之后可能会有进位Carry产生，然后在下一位
//    计算时需要加上进位一起运算，那么我们能不能将两部分拆开呢，我们来
//    看一个例子759+674
//    1. 如果我们不考虑进位，可以得到323
//    2. 如果我们只考虑进位，可以得到1110
//    3. 我们把上面两个数字假期323+1110=1433就是最终结果了
//    然后我们进一步分析，如果得到上面的第一第二种情况，我们在二进制下来看，
//    不考虑进位的加，0+0=0， 0+1=1, 1+0=1， 1+1=0，这就是异或的运算规则，
//    如果只考虑进位的加0+0=0, 0+1=0, 1+0=0, 1+1=1，而这其实这就是与的运算，
//    而第三步在将两者相加时，我们再递归调用这个算法，终止条件是当进位为0时，
//    我们直接返回第一步的结果，参见代码如下：
    public int getSum(int a, int b) {
        while(b!=0){
            int c = a&b;
            a=a^b;
            b=c<<1;
        }
        return a;
    }
}
