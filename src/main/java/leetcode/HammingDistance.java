package leetcode;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,254));
    }
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
