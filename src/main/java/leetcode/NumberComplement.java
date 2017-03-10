package leetcode;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberComplement {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Number = " + i);
//            System.out.println(Integer.highestOneBit(i));
//            System.out.println("Binary = " + Integer.toBinaryString(i));
//            System.out.println("====================");
//        }

        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(6));
    }
    public int findComplement(int num) {
        //System.out.println(Integer.highestOneBit(num));
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num^mask;
    }
}
