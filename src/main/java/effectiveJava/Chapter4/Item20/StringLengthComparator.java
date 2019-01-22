package effectiveJava.Chapter4.Item20;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lyk on 2019-1-22.
 * Package name: effectiveJava.Chapter4.Item20.tagged
 * Porject name: untitled1
 */
public class StringLengthComparator {
    public static void main(String[] args) {
        String[] a = {"abcdefg", "abc", "abcdefghijk"};
        Stream.of(a).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        Arrays.sort(a, Host.STRING_LENGTH_COMPARATOR);
        Stream.of(a).forEach(n -> System.out.print(n + " : "));
    }
}
