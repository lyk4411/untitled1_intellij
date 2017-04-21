package leetcode;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        BulbSwitcher bs = new BulbSwitcher();
        System.out.println(bs.bulbSwitch(100));
    }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
