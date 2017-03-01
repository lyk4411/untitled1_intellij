package example;

import java.util.Optional;
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


    }
}
