package leetcode;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RangeAdditionII {
    public static void main(String[] args) {
        RangeAdditionII raii = new RangeAdditionII();
        int[][] ops = new int[][]{
                {2,2},
                {3,3},
                {4,4},
                {5,5}
        };
        System.out.println(raii.maxCount(5,5,ops));
    }
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for(int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }

        return row * col;
    }
}
