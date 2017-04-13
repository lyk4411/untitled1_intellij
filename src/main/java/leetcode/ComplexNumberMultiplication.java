package leetcode;

import java.util.stream.Stream;

/**
 * Created by lyk on 2017/4/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        ComplexNumberMultiplication cnm = new ComplexNumberMultiplication();
        System.out.println(cnm.complexNumberMultiply("11+2i","23+-8i"));
    }
    public String complexNumberMultiply(String a, String b) {
        int[] c1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        int[] c2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (c1[0]*c2[0] - c1[1]*c2[1]) + "+" + (c1[0]*c2[1] + c1[1]*c2[0]) + "i";
    }
}
