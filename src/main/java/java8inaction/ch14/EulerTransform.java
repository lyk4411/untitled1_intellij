package java8inaction.ch14;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by lyk on 2019-2-21.
 * Package name: java8inaction.ch14
 * Porject name: untitled1
 */
public class EulerTransform implements Function<Double, Double> {

    double n1 = 0.0;
    double n2 = 0.0;
    double n3 = 0.0;

    @Override
    public Double apply(Double t) {
        n1 = n2;
        n2 = n3;
        n3 = t;
        if (n1 == 0.0) {
            return 0.0;
        }
        return calc();
    }

    double calc() {
        double d = n3 - n2;
        return n3 - d * d / (n1 - 2 * n2 + n3);
    }

    public static void main(String[] args) {
        Stream<Double> piStream2 = Stream.generate(new PiSupplier());
        piStream2.map(new EulerTransform())
                .skip(100)
                .limit(10)
                .forEach(System.out::println);

        Stream<Double> piStream3 = Stream.generate(new PiSupplier());
        piStream3.map(new EulerTransform())
                .map(new EulerTransform())
                .map(new EulerTransform())
                .map(new EulerTransform())
                .map(new EulerTransform())
                .limit(20)
                .forEach(System.out::println);
    }
}