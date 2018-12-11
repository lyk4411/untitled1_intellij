package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lyk on 2018-12-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        ReorderLogFiles rlf = new ReorderLogFiles();
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] results = rlf.reorderLogFiles(logs);
        Stream.of(results).forEach(System.out::println);
    }
}
