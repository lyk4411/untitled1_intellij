package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] citations = new int[]{1,2,3,4,0,6,3,2,5};
        System.out.println(hi.hIndex(citations));
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            result = Math.max(result, smaller);
        }

        return result;
    }
}
