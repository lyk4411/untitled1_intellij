package example;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by lyk on 2017/3/1.
 * Package name: example
 * Porject name: untitled1
 */
public class testOptional {

    public  static  void main(String[] args){
        Optional<String> name = Optional.ofNullable("Tom");
        System.out.println("name set?" + name.isPresent());
        System.out.println("name:" + name.orElseGet(()-> "no name."));
        System.out.println(name.map(s-> "hey " + s + "!").orElse("hey guest."));

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2);

        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));


    }
}
