package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] a = new int[10];
        for(int i=0;i<5;i++){
            a[i]=i;
        }
        int[] b = new int[]{4,5,6,7,8};
        msa.merge(a,5,b,5);
        for(int ai:a) {
            System.out.println(ai);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        int i = m + n + 1;
        while(m >= 0 || n >= 0){
            if(m < 0){
                nums1[i--] = nums2[n--];
            } else if(n < 0) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
        }
    }
}
