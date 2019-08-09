package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-8-9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SortanArray {
    public int[] sortArray(int[] nums) {
        return IntStream.of(nums).sorted().toArray();
    }

    public static void main(String[] args) {
        SortanArray sa = new SortanArray();
        IntStream.of(sa.sortArray(new int[]{5,2,3,1})).forEach(n -> System.out.print(n + " "));
    }
}
