package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NimGame {
    public static void main(String[] args) {
        NimGame ng = new NimGame();
        System.out.println(ng.canWinNim(10));
        System.out.println(ng.canWinNim(11));
        System.out.println(ng.canWinNim(12));
    }
    public boolean canWinNim(int n) {
        return n%4>0;
    }
}
