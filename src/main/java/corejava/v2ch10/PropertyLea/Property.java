package corejava.v2ch10.PropertyLea;

import java.lang.annotation.*;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PropertyLea
 * Porject name: untitled1
 */

@Target(ElementType.METHOD)              // 该注解可以作用于方法声明
@Retention(RetentionPolicy.RUNTIME)     // 该注解会一直保留到运行时
@Documented                            // 将注解信息保留到 Javadoc中
@Inherited                            // 该注解可以被子类继承
public @interface Property {
    int id();                          // int 类型元素 id
    String msg() default "default msg";  // 默认值为 “default msg” 的 String 类型元素 msg
//   Boolean flag() default false;    // Invalide type 'Boolean' for annotaton member
}