package java8inaction.ch14;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by lyk on 2019-2-21.
 * Package name: java8inaction.ch14
 * Porject name: untitled1
 */
public class PiSupplier implements Supplier<Double> {

    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4) / this.current;
        this.current = this.current + 2.0;
        this.sign = ! this.sign;
        return sum;
    }

    public static void main(String[] args) {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.skip(10000).limit(10)
                .forEach(System.out::println);
    }
}
