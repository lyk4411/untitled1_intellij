package corejava.v2ch10.PropertyLearn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PropertyLearn
 * Porject name: untitled1
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Property {

    //属性名称
    String name() default "";

}
