package example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist =
                Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is ‘Object’
        flist.indexOf(new Apple()); // Argument is ‘Object’

        //flist.add(new Apple());   无法编译

    }
}