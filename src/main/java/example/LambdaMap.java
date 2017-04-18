package example;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lyk on 2017/4/18.
 * Package name: example
 * Porject name: untitled1
 */
public class LambdaMap {
    public static void main(String[] args) {
        Stream<String> introStream = Stream.
                of("Get started with UICollectionView and the photo library".split(" "));
        Map<String, String> introMap =
                introStream.collect(Collectors.toMap(s -> s.substring(0, 1), s -> s));
        Iterator it = introMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
            System.out.println(pair.getKey()+"="+pair.getValue());
        }
    }
}
