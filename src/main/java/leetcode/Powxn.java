package leetcode;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Powxn {
    public static void main(String[] args) {
        Powxn p = new Powxn();
        System.out.println(p.pow(4.15,8));
    }
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
