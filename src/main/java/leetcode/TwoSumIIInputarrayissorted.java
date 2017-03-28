package leetcode;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TwoSumIIInputarrayissorted {
    public static void main(String[] args) {
        TwoSumIIInputarrayissorted tsiii = new TwoSumIIInputarrayissorted();
        int[] numbers = new int[]{1,2,3,5,6,8,9,10};
        int[] result = tsiii.twoSum(numbers,11);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ":");
        }
        System.out.println();
    }
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return null;
    }
}
