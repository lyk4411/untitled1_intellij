package leetcode;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumDistanceinArrays {
    public static void main(String[] args) {
        MaximumDistanceinArrays mda = new MaximumDistanceinArrays();
        int[][] arrays = new int[][]{
                {1,2,3},
                {4,5},
                {1,2,3}
        };
        System.out.println(mda.maxDistance(arrays));
    }
    public int maxDistance(int[][] arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays[0][arrays[0].length - 1];
        int min = arrays[0][0];

        for (int i = 1; i < arrays.length; i++) {
            result = Math.max(result, Math.abs(arrays[i][0] - max));
            result = Math.max(result, Math.abs(arrays[i][arrays[i].length - 1] - min));
            max = Math.max(max, arrays[i][arrays[i].length - 1]);
            min = Math.min(min, arrays[i][0]);
        }

        return result;
    }
}
