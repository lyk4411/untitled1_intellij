package leetcode;


import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int sum1 = 0, sum2 = 0, ans = 0;
        int[] arr1 = IntStream.of(arr).sorted().toArray();
        for(int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += arr1[i];
            if(sum1 == sum2) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII mctmsii = new MaxChunksToMakeSortedII();
        int[] nums1 = new int[]{4,3,2,1,0};
        int[] nums2 = new int[]{1,0,2,3,4};
        int[] nums3 = new int[]{1,2,0,3};
        int[] nums4 = new int[]{2,1,3,4,4};

        System.out.println(mctmsii.maxChunksToSorted(nums1));
        System.out.println(mctmsii.maxChunksToSorted(nums2));
        System.out.println(mctmsii.maxChunksToSorted(nums3));
        System.out.println(mctmsii.maxChunksToSorted(nums4));
    }
}



class Pair1 {
    int val;
    int count;
    Pair1(int v, int c) {
        val = v;
        count = c;
    }
    int compare(Pair1 that) {
        return this.val != that.val ? this.val - that.val : this.count - that.count;
    }
}