package leetcode;

import java.util.stream.Stream;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FractionAdditionandSubtraction {
    public static void main(String[] args) {
        FractionAdditionandSubtraction fas = new FractionAdditionandSubtraction();
        String expression = new String("-1/2+1/2+1/3");
        System.out.println(fas.fractionAddition(expression));
    }
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-,+])"); // splits input string into individual fractions
        String res = "0/1";
        for (String frac : fracs) res = add(res, frac); // add all fractions together
        return res;
    }

    public String add(String frac1, String frac2) {
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
        String sign = "";
        if (numer < 0) {sign = "-"; numer *= -1;}
        return sign + numer/gcd(numer, denom) + "/" + denom/gcd(numer, denom); // construct reduced fraction
    }

    // Computes gcd using Euclidean algorithm
    public int gcd(int x, int y) {
        if(x == 0 || y == 0) return x + y;
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        int t = x;

        while (x%t != 0 || y%t != 0){
            t--;
        }
        return t;
    }
}
