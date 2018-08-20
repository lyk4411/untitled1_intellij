package corejava.v2ch10.PropertyLearn;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PropertyLearn
 * Porject name: untitled1
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Properties;

public class PropertyParse extends PropertyPlaceholderConfigurer implements
        BeanPostProcessor, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(PropertyParse.class);
    private Properties pros = null;

    // 在spring容器实例化bean之后添加自己的逻辑
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    // 在spring容器实例化bean之前添加自己的逻辑
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean.getClass().getAnnotation(Property.class) != null) {
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method method : methods) {
                Property p = method.getAnnotation(Property.class);
                if (p != null) {
                    //获得对应名称的属性的值
                    Object para = pros.getProperty(p.name());
                    //方法参数类型名称
                    String parameterName = (method.getParameterTypes()[0]).getName();

                    if (parameterName.equals("java.lang.Integer")) {
                        para = new Integer(para.toString());
                    }else if (parameterName.equals(
                            "java.lang.Double")) {
                        para = new Long(para.toString());
                    }else if (parameterName.equals(
                            "java.lang.String")) {
                        para = para.toString();
                    }
                    logger.info("获得了指定名称的属性的值：" + para);
                    ReflectionUtils.invokeMethod(method, bean,
                            new Object[] { para });
                }
            }
        }
        return bean;
    }

    // 在初始化bean的时候执行该方法
    public void afterPropertiesSet() throws Exception {
        //此方法的作用是将配置的和系统属性加载进来
        pros = mergeProperties();
    }
}
