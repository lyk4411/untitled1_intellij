package leetcode;

/**
 * Created by lyk on 2018-4-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BulbSwitcherII {
//    由于这道题最多只有8中情况，所以很适合分情况来讨论：
//    - 当m和n其中有任意一个数是0时，返回1
//    - 当n = 1时
//    只有两种情况，0和1
//    - 当n = 2时，
//    这时候要看m的次数，如果m = 1，那么有三种状态 00，01，10
//    当m > 1时，那么有四种状态，00，01，10，11
//            - 当m = 1时，
//    此时n至少为3，那么我们有四种状态，000，010，101，011
//            - 当m = 2时，
//    此时n至少为3，我们有七种状态：111，101，010，100，000，001，110
//            - 当m > 2时，
//    此时n至少为3，我们有八种状态：111，101，010，100，000，001，110，011
//
public int flipLights(int n, int m) {

    if (n == 0 || m == 0) return 1;
    if (n == 1) return 2;
    if (n == 2) return m == 1 ? 3 : 4;
    if (m == 1) return 4;
    return m == 2 ? 7 : 8;
}

//    public int flipLights(int n, int m) {
//        Set<Integer> seen = new HashSet();
//        n = Math.min(n, 6);
//        int shift = Math.max(0, 6-n);
//        for (int cand = 0; cand < 16; ++cand) {
//            int bcount = Integer.bitCount(cand);
//            if (bcount % 2 == m % 2 && bcount <= m) {
//                int lights = 0;
//                if (((cand >> 0) & 1) > 0) lights ^= 0b111111 >> shift;
//                if (((cand >> 1) & 1) > 0) lights ^= 0b010101 >> shift;
//                if (((cand >> 2) & 1) > 0) lights ^= 0b101010 >> shift;
//                if (((cand >> 3) & 1) > 0) lights ^= 0b100100 >> shift;
//                seen.add(lights);
//            }
//        }
//        return seen.size();
//    }

    public static void main(String[] args) {
        BulbSwitcherII bsii = new BulbSwitcherII();
        System.out.println(bsii.flipLights(16,1));
        System.out.println(bsii.flipLights(16,2));
        System.out.println(bsii.flipLights(16,3));
        System.out.println(bsii.flipLights(16,4));
        System.out.println(bsii.flipLights(16,5));
        System.out.println(bsii.flipLights(16,6));
        System.out.println(bsii.flipLights(16,7));
        System.out.println(bsii.flipLights(16,8));
        System.out.println(bsii.flipLights(16,9));

    }
}
