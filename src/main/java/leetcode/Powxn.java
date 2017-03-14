package leetcode;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Powxn {
    public static void main(String[] args) {
        Powxn p = new Powxn();

        System.out.println(p.myPow(1.00000,-2147483648));
        System.out.println(p.myPow(2.00000,-2147483648));

    }

    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            if(n == -2147483648) {n = n+2;}
            n = -n;
            x = 1.0/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

//    public double myPow(double x, int n) {
//        if(n<0){
//            return 1.0/power(x, -n);
//        }else {
//            return power(x, n);
//        }
//    }
//    public double power(double x, int n){
//        if(n==0)
//            return 1;
//        double v = power(x, n/2);
//        if(n%2==0)
//            return v*v;
//        else
//            return v*v*x;
//    }
//    public double myPow(double x, int n){
//        if(n==0)
//            return 1;
//
//        if(n<0){
//            return 1.0/myPow(x, -n);
//        }
//
//        double v = myPow(x, n/2);
//
//        if(n%2==0){
//            return v*v;
//        }else{
//            return v*v*x;
//        }
//    }
}
