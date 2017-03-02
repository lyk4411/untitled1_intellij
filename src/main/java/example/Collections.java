package example;

import java.util.List;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */

public class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,(T)src.get(i));
    }
}