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
