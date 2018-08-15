package corejava.v2ch09.lisptest;

/**
 * Created by lyk on 2018-8-15.
 * Package name: corejava.v2ch09.lisptest
 * Porject name: untitled1
 */
public class lisptest {
    public double improve(double guess, double x){
        return ((x / guess)  + guess)/ 2.0;
    }
    public boolean goodenough(double guess, double x){
        return Math.abs(guess * guess - x) < 0.00001;
    }
    public double tryit(double guess, double x){
        if(goodenough(guess, x)) {
            return guess;
        } else {
            return tryit(improve(guess, x), x);
        }
    }
    public static void main(String[] args) {
        lisptest lt = new lisptest();
        System.out.println(lt.tryit(1, 36));
        System.out.println(lt.tryit(1, 16));
        System.out.println(lt.tryit(1, 26));
    }
}
