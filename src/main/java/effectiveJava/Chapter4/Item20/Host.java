package effectiveJava.Chapter4.Item20;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by lyk on 2019-1-22.
 * Package name: effectiveJava.Chapter4.Item20
 * Porject name: untitled1
 */

public class Host {
    private static class StrLenCmp implements Comparator<String>, Serializable {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}