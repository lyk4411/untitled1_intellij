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
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
