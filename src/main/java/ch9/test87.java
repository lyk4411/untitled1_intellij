package ch9;

import java.util.ArrayList;

/**
 * Created by lyk on 2016/10/17.
 * Package name: ch9
 * Porject name: untitled1
 */
public class test87 {
    public static  void main(String[] args){
        long a17 = 1;
        ArrayList<Long> al = new ArrayList<Long>();
        ArrayList<Long> pral = new ArrayList<Long>();

        for(int i=0;i<10000;i++){
            long result = i* a17;
            if(String.valueOf(result).startsWith("1") &&
                    String.valueOf(result).endsWith("1")){
                al.add(result);
            }
        }
        System.out.println(String.valueOf(al));
        for(Long element:al){
            if(isPrime(element)){
                pral.add(element);
            }
        }
        System.out.println(String.valueOf(pral));

    }
    public static boolean isPrime(long n){
        for (long i = 2; i<= Math.sqrt(n); i+=1){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
