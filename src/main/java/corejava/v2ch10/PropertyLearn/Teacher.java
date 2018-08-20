package corejava.v2ch10.PropertyLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PropertyLearn
 * Porject name: untitled1
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Property
public class Teacher implements Serializable {

    private static final long serialVersionUID = 7651360997972750779L;
    private static Logger logger = LoggerFactory.getLogger(Teacher.class);

    @Property(name = "third.kute.blog")
    public void setValue(String value) {
        logger.info("成功设String值：" + value);
    }

    @Property(name = "second.kute.age")
    public void setValue(Integer value) {
        logger.info("成功设Integer值：" + value);
    }

    @Property(name = "first.kute.name")
    public void setValue(Double value) {
        logger.info("成功设Double值：" + value);
    }
}
