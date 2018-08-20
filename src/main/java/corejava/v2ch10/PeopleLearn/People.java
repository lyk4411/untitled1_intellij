package corejava.v2ch10.PeopleLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PeopleLearn
 * Porject name: untitled1
 */


import java.lang.annotation.*;

/**
 * 使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
 * 在定义注解时，不能继承其他的注解或接口。
 * @interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。
 * 方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。
 * 可以通过default来声明参数的默认值,如果不指定default，则该参数为必设项
 *
 * Annotation类型里面的参数该怎么设定:
 * 第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默认类型；
 * 第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型
 * 	       和 String,Enum,Class,annotations等数据类型以及这一些类型的数组.
 * 第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号.
 *
 * 注解元素必须有确定的值，要么在定义注解的默认值中指定，要么在使用注解时指定，非基本类型的注解元素的值不可为null。
 * 因此, 使用空字符串或0作为默认值是一种常用的做法。这个约束使得处理器很难表现一个元素的存在或缺失的状态，
 * 因为每个注解的声明中，所有元素都存在，并且都具有相应的值，为了绕开这个约束，我们只能定义一些特殊的值["",-1]等，
 * 例如空字符串或者负数，一次表示某个元素不存在，在定义注解时，这已经成为一个习惯用法。
 *
 * 定义了注解，并在需要的时候给相关类，类属性加上注解信息，如果没有响应的注解信息处理流程，
 * 注解可以说是没有实用价值。如何让注解真真的发挥作用，主要就在于注解处理方法
 *
 * @Target注解参数
 * 1.CONSTRUCTOR:构造函数
 * 2.FIELD:字段，枚举常量
 * 3.LOCAL_VARIABLE:局部变量
 * 4.METHOD:方法
 * 5.PACKAGE:包
 * 6.PARAMETER:方法参数
 * 7.TYPE:接口，类，枚举，注解
 *
 * 下面就开始定义一个@People的注解
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface People {

    //定义一个枚举，（男人，女人，好人，坏人，大人，小人）
    public enum PeopleType{MAN, WOMAN, GOODMAN, BADMAN, BIGMAN, SMALLMAN}
    //定义了一个注解参数：人的类型，默认为男人
    public PeopleType type() default PeopleType.MAN;

    public String name() default "";
    //此参数没有指定default，所以用@People注解的时候必须指定该参数
    public int age();

    public String[] fruitColor() default { "red", "black" };

}
