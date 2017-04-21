package leetcode;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UTF8Validation {
    public static void main(String[] args) {
        UTF8Validation utf8Validation = new UTF8Validation();
        int[] data1 = new int[]{1,2,3,4,5};
        int[] data2 = new int[]{197, 130, 1};
        System.out.println(utf8Validation.validUtf8(data1));
        System.out.println(utf8Validation.validUtf8(data2));
    }
    public boolean validUtf8(int[] data) {
        /* 1. check how many '1's = ones
         * 2. check (i + 1, i + ones - 1) for '10'
         * 3. update i = i + ones
         * valid ones: 0, 2, 3, 4
         */
        int i = 0;
        while(i < data.length) {
            // 1. find ones
            int ones = 0;
            while(((data[i] >> (7 - ones)) & 1) == 1) {
                ones++;
            }
            // invalid ones
            if(ones == 1 || ones > 4) return false;
            // 2. check 1s
            i++;
            while(ones-- > 1) {
                if(i >= data.length || (data[i] >> 6)  != 2) return false;
                // 3. update i
                i++;
            }
        }

        return true;
    }
}
