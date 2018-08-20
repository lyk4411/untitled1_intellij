package corejava.v2ch10.PeopleLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PeopleLearn
 * Porject name: untitled1
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;


public class AnnotionParse {

    private static Logger logger = LoggerFactory.getLogger(AnnotionParse.class);

    public void parse(Class clazz) {
        try {
            Object clasz = clazz.getConstructor(new Class[] {}).newInstance(
                    new Object[] {});
            // clasz类上是否标注有People这个注解
            if (null != clasz.getClass().getAnnotation(People.class)) {
                Method[] methods = clasz.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    // annotation是方法上的注解
                    People people = method.getAnnotation(People.class);
                    if (null != people) {
                        // 得到注解上的type参数的值
                        Object oType = people.type();
                        Object oName = people.name();
                        int oAge = people.age();
                        String[] fruitColor = people.fruitColor();

                        StringBuffer buffer = new StringBuffer();
                        for (String s : fruitColor)
                            buffer.append(s + ",");

                        logger.info("取出了方法的参数：[oType:" + oType + "],[oName:"
                                + oName + "],[oAge:" + oAge + "],[fruitColor:"
                                + buffer.toString() + "]");

                        // 判断oType的类型是否是要指定的类型
                        if (method.getParameterTypes()[0]
                                .equals("corejava.v2ch10.PeopleLearn.People.PeopleType")) {
                            oType = (People.PeopleType) oType;
                        }
                        if (method.getParameterTypes()[1]
                                .equals("java.lang.String")) {
                            oName = oName.toString();
                        }
                        // 反射调用方法并传递参数
                        ReflectionUtils.invokeMethod(method, clasz,
                                new Object[] { oType, oName, oAge, fruitColor });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
