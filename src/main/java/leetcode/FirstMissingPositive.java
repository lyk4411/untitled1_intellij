package leetcode;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = new int[]{1,2,3,5,7,3,9,2,8,10};
        System.out.println(fmp.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) {
                swap(A, i, A[i]-1);
//                System.out.print("i:" + i + ":");
//                for (int j = 0; j < A.length; j++) {
//                    System.out.print(A[j] + " ");
//                }
//                System.out.println();
            }
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
