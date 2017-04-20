package example;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2017/4/20.
 * Package name: example
 * Porject name: untitled1
 */
public class CountingBits {
    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int[] results1 = cb.countBits(10);
        int[] results2 = cb.countBits(5);
        IntStream.of(results2).forEach(i -> System.out.print(i + " : "));
        System.out.println();
        IntStream.of(results1).forEach(i -> System.out.print(i + " : "));
    }
    public int[] countBits(int num) {
        int[] result = new int[num+1];

        for(int i=0; i<=num; i++){
            result[i] = countEach(i);
        }

        return result;
    }

    public int countEach(int num){
        int result = 0;

        while(num!=0){
            if(num%2==1){
                result++;
            }
            num = num/2;
        }

        return result;
    }

}
