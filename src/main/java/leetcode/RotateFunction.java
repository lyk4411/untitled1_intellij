package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RotateFunction {
    public static void main(String[] args) {
        RotateFunction rf = new RotateFunction();
        int[] A = new int[]{4, 3, 2, 6};
        System.out.println(rf.maxRotateFunction(A));
    }
    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }

        int sum =0, iteration = 0, len = A.length;

        for(int i=0; i<len; i++){
            sum += A[i];
            iteration += (A[i] * i);
        }

        int max = iteration;
        for(int j=1; j<len; j++){
            // for next iteration lets remove one entry value of each entry and the prev 0 * k
            iteration = iteration - sum + A[j-1]*len;
            max = Math.max(max, iteration);
        }

        return max;
    }
}
