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

//    Sum是数组A各位累加和，iteration是按照pattern对数组乘积变换后的累加和，
//    max是题目所求的不同变换累加和的最大值。
//
//    Sum = 1A + 1B + 1C + 1D;
//    iteration = 0A + 1B + 2C + 3D;
//
//    然后做一个递归：每次对iteration减少Sum，并加上当前递归对应的A[i]*len，这样做的道理是什么呢：
//
//    max = iteration = 0A + 1B + 2C + 3D;
//    A[i]*len = 4A;
//    iteration = -A + 0B + 1C + 2D + 4A = 0B + 1C + 2D + 3A;
//    max = Math.max(max, iteration)= Math.max(0A1B2C3D, 3A0B1C2D);
//
//    也就是说，每一次循环，相当于改变一次pattern，从0123到3012，再到2301，到1230结束，取这之中的最大值返回即可。
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
