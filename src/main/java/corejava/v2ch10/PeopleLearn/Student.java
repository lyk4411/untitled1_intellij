package corejava.v2ch10.PeopleLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PeopleLearn
 * Porject name: untitled1
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


@People(age = 20)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(Student.class);

    @People(type = People.PeopleType.GOODMAN, name = "kute", age = 18, fruitColor = {
            "blue", "white", "green" })
    public void setValue(People.PeopleType stuType, String stuName, int stuAge,
                         String[] fruitColor) {

        StringBuffer buffer = new StringBuffer();
        for (String color : fruitColor)
            buffer.append(color + ",");
        logger.info("成功调用了方法并注入了参数:[" + stuType + "," + stuAge + "," + stuName
                + ", {" + buffer.toString() + "} ]");
    }


}
