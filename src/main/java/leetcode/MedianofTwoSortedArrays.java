package leetcode;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
        int[] n1 = new int[]{1,2,3,4,5,6};
        int[] n2 = new int[]{3,4,5,6,7,8};
        System.out.println(mtsa.findMedianSortedArrays(n1,n2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
            if ((m + n) % 2 == 0) {
                return (getMedian(nums1, m, nums2, n, (m+n)/2) +
                        getMedian(nums1, m,nums2, n, (m+n)/2+1)) /2.0;
            } else {
                return getMedian(nums1, m,nums2, n, (m+n)/2+1);
        }
    }

    private double getMedian(int[] nums1, int m, int[] nums2, int n, int k) {
        if(m>n){
            return getMedian(nums2,n,nums1,m,k);
        }
        if(m==0){
            return nums2[k-1];
        }
        if(k==1){
            return Math.min(nums1[0],nums2[0]);
        }
        int pa = Math.min(k/2,m);
        int pb = k - pa;
        int[] A = new int[m-pa];
        int[] B = new int[n-pb];
        if (nums1[pa-1] < nums2[pb-1]) {
            for(int i=pa;i<nums1.length;i++){
                A[i-pa]=nums1[i];
            }
            return getMedian(A, m-pa, nums2, n, k-pa);
        } else if(nums1[pa-1] > nums2[pb-1]) {
            for(int i=pb;i<nums2.length;i++){
                B[i-pb]=nums2[i];
            }
            return getMedian(nums1, m, B, n-pb, k-pb);
        }else{
            return nums1[pa-1];
        }
    }
}
