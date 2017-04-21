package leetcode;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShuffleanArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ShuffleanArray sa = new ShuffleanArray(nums);
        IntStream.of(sa.reset()).forEach(i -> System.out.print(i + " : "));System.out.println();
        IntStream.of(sa.shuffle()).forEach(i -> System.out.print(i + " : "));System.out.println();
        IntStream.of(sa.reset()).forEach(i -> System.out.print(i + " : "));System.out.println();
        IntStream.of(sa.shuffle()).forEach(i -> System.out.print(i + " : "));System.out.println();
        IntStream.of(sa.reset()).forEach(i -> System.out.print(i + " : "));System.out.println();
    }

    private int[] nums;
    private Random random;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
