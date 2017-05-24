package leetcode;

/**
 * Created by lyk on 2017/5/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        StudentAttendanceRecordII sarii = new StudentAttendanceRecordII();
        System.out.println(sarii.checkRecord(1));
        System.out.println(sarii.checkRecord(3));
    }

//    下面这种方法来自大神KJer的帖子，大神帖子里面的讲解写的很详细，很赞，也不难读懂。
//    定义了三个DP数组P, L, A，其中P[i]表示数组[0,i]范围内以P结尾的所有排列方式，L[i]
//    表示数组[0,i]范围内以L结尾的所有排列方式，A[i]表示数组[0,i]范围内以A结尾的所有
//    排列方式。那么最终我们所求的就是P[n-1] + L[n-1] + A[n-1]了。那么难点就是分别求
//    出P, L, A数组的递推公式了。
//    首先来看P数组的，P字符没有任何限制条件，可以跟在任何一个字符后面，所以有
//    P[i] = A[i-1] + P[i-1] + L[i-1]
//    再来看L数组的，L字符唯一的限制条件是不能有超过两个连续的L，那么在P和L字符后面
//    可以加1一个L，如果前一个字符是L，我们要看再前面的一位是什么字符，如果是P或着A的
//    话，可以加L，如果是L的话，就不能再加了，否则就连续3个了，所以有
//    L[i] = A[i-1] + P[i-1] + A[i-2] + P[i-2]
//    最后来看A数组的，这个比较麻烦，字符A的限制条件是整个字符串最多只能有1个A，那么
//    当前一个字符是A的话，就不能再加A来，当前一个字符是P或者L的话，要确定之前从没有
//    A出现过，才能加上A。那么实际上我们还需要定义两个数组P1, L1, 其中P1[i]表示数
//    组[0,i]范围内以P结尾的不包含A的所有排列方式，L1[i]表示数组[0,i]范围内以L结尾的
//    不包含A的所有排列方式，根据前两种情况我们不难推出P1和L1的递推公式，再加上A的递
//    推公式如下：
//    A[i] = P1[i-1] + L1[i-1]
//    P1[i] = P1[i-1] + L1[i-1]
//    L1[i] = P1[i-1] + P1[i-2]
//    将第二第三个等式多次带入第一个等式，就可以将P1和L1消掉，可以化简为：
//    A[i] = A[i-1] + A[i-2] + A[i-3]
//    这样就可以少定义两个数组了，递推公式有了，代码也就不难写了：
    public int checkRecord(int n) {
        if(n == 0) return 1;
        if(n == 1) return 3;
        if(n == 2) return 8;
        final  int MOD = 1000000007;
        int[] P = new int[n + 1];
        int[] A = new int[n + 1];
        int[] L = new int[n + 1];
        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        for (int i = 1; i < n; ++i) {
            P[i] = ((P[i - 1] + L[i - 1]) % MOD + A[i - 1]) % MOD;
            if (i > 1) L[i] = ((A[i - 1] + P[i - 1]) % MOD + (A[i - 2] + P[i - 2]) % MOD) % MOD;
            if (i > 2) A[i] = ((A[i - 1] + A[i - 2]) % MOD + A[i - 3]) % MOD;
        }
        return ((A[n - 1] + P[n - 1]) % MOD + L[n - 1]) % MOD;
    }



//    public int checkRecord(int n) {
//        final int MOD = 1000000007;
//        int[][][] f = new int[n + 1][2][3];
//
//        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
//        for (int i = 0; i < f.length; i++) {
//            for (int j = 0; j < f[0].length; j++) {
//                for (int k = 0; k < f[0][0].length; k++) {
//                    System.out.print("i:" + i + " j:" + j  + " k:" + k + " f[i][j][k]:" +  f[i][j][k] + "  " );
//                }
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= n; i++)
//            for (int j = 0; j < 2; j++)
//                for (int k = 0; k < 3; k++) {
//                    int val = f[i - 1][j][2]; // ...P
//                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
//                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
//                    f[i][j][k] = val;
//                }
//        return f[n][1][2];
//    }
}
