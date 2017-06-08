package leetcode;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArrayNesting {
    public static void main(String[] args) {
        ArrayNesting an = new ArrayNesting();
        int[] a = new int[]{5,4,0,3,1,6,2};
        System.out.println(an.arrayNesting(a));
        System.out.println(an.arrayNesting(a));
    }
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}
