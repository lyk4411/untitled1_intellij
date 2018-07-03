package leetcode;

/**
 * Created by lyk on 2018-7-3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PoorPigs {
    public int poorPigs(int buckets, int timeToDie, int timeToTest) {
        int pigs = 0;
        while (Math.pow((timeToTest / timeToDie + 1), pigs) < buckets) {
            pigs++;
            }
        return pigs;
    }

    public static void main(String[] args) {
        PoorPigs pp = new PoorPigs();
        System.out.println(pp.poorPigs(10000, 15, 60));
    }
}
