package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/6/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DesignCompressedStringIterator {
    public static void main(String[] args) {
        DesignCompressedStringIterator dcsi = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");
        String[] arr = dcsi.arr;
        int[] counts = dcsi.counts;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }

    }
    int i;
    String[] arr;
    int[] counts;

    public DesignCompressedStringIterator(String str) {
        arr = str.split("\\d+");
        counts = Arrays.stream(str.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();
    }

    public char next() {
        if(!hasNext()) return ' ';
        char ch = arr[i].charAt(0);
        if(--counts[i] == 0) ++i;
        return ch;
    }

    public boolean hasNext() {
        if(i == arr.length) return false;
        return true;
    }
}
