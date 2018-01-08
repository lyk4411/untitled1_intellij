package JUnitLearn.ch02;

/**
 * Created by lyk on 2018-1-8.
 * Package name: JUnitLearn.ch02
 * Porject name: untitled1
 */
public class Largest {
    public  static int largest(int[] list){
        int index,max=Integer.MIN_VALUE;
        if(list.length == 0){
            throw new RuntimeException("Empty list.");
        }
        for(index = 0; index <= list.length - 1; index++){
            if (list[index] > max){
                max = list[index];
            }
        }
        return max;
    }
}
