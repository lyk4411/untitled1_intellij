package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-4-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1, width = 0;
        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }

    public static void main(String[] args) {
        NumberofLinesToWriteString ntws = new NumberofLinesToWriteString();
        int[] widths = new int[]{4,10,10,10,10,10,10,
                10,10,10,10,10,10,10,10,10,10,10,10,
                10,10,10,10,10,10,10};
        String s1 = new String("bbbcccdddaaa");
        IntStream.of(ntws.numberOfLines(widths,s1)).
                forEach(n -> System.out.print(n + " "));
    }
}
