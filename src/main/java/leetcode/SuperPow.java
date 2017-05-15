package leetcode;

/**
 * Created by lyk on 2017/5/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SuperPow {
    public static void main(String[] args) {
        SuperPow sp = new SuperPow();
        int a = 1545;
        int[] b = new int[]{1,2};
        System.out.println(sp.superPow(a,b));
    }
    /**
     * 这道题是ACM里面入门问题，powmod，详细的算法可以参照这里：http://blog.csdn.net/xuruoxin/article/details/8578992
     * */

    // 判断是否大于0
    public boolean morethanzero(int[] x){
        for(int i=x.length-1;i>=0;i--){
            if(x[i]>0) return true;
        }
        return false;
    }

    //高精度除法
    public void div(int[] x,int y){
        int tmp=0;
        for(int i=0;i<x.length;i++){
            x[i] += tmp*10;
            tmp = x[i] % y;
            x[i] = x[i] /y;
        }

    }

    public int superPow(int a, int[] b) {
        if (morethanzero(b) == false) return 1;
        a=a%1337;
        boolean isEven = false;
        if(b[b.length-1] % 2 == 0) isEven = true;
        div(b,2);
        int result = superPow(a,b);
        result = result % 1337;
        result*=result;
        result = result % 1337;
        if(isEven==false){
            result*=a;
            result = result % 1337;
        }
        return result;
    }
}
