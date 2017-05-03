package leetcode;

/**
 * Created by lyk on 2017/5/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class EliminationGame {
    public static void main(String[] args) {
        EliminationGame eg = new EliminationGame();
        System.out.println(eg.lastRemaining(15));
        System.out.println(eg.lastRemaining(150));
        System.out.println(eg.lastRemaining(1500));

    }
    //关键在于维护一个boolean变量left2right来表明当前这一轮elimination是否为
    // 从左往右。另外，对于当前这一step来说，如果所剩的元素个数为奇数，那么头
    // 尾元素都会被去掉，否则的话头元素被去掉，但是尾元素不变。相邻元素的距离
    // 随着每一步都会放大两倍。
    // 详细：http://www.mamicode.com/info-detail-1658523.html
    public int lastRemaining(int n) {
        int gap = 1;
        int low = 1;
        int high = n;
        boolean left2right = true;
        while (low < high){
            int temp = (high - low) / gap;
            if(left2right){
                low += gap;
                if(temp%2 == 0){
                    high -= gap;
                }
            } else {
                high -= gap;
                if(temp%2 == 0){
                    low += gap;
                }
            }
            gap *=2;
            left2right = !left2right;
        }
        return low;
    }
}
