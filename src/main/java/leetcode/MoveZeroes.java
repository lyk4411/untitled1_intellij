package leetcode;

import java.util.stream.Stream;

/**
 * Created by lyk on 2017/2/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MoveZeroes {

    public  static void main(String[] args){
        MoveZeroes mz = new MoveZeroes();
        int[] a = new int[]{1,0,3,0,9,8,0,0,0,6,5,4};
        mz.moveZeroes(a);
        Integer[] ll = new Integer[a.length];
        for(int i=0;i<a.length;i++){
            ll[i] = a[i];
        }

        Stream.of(ll).forEach(System.out::println);
    }
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }}
