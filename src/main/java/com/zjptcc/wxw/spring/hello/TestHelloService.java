package com.zjptcc.wxw.spring.hello;

/**
 * Created by lyk on 2016/7/5.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloService {

    /**
     * @param args
     */
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        ctx = new ClassPathXmlApplicationContext("hello-beans.xml");

        //用接口
        IHelloService helloWorld = (IHelloService) ctx
                .getBean("helloService");
        helloWorld.sayHello();
        helloWorld.sayChinaHello();

        System.out.println("------------------------------------------------------------------------------------");

        //用类
        SimpleHelloBean SimpleHello = (SimpleHelloBean) ctx
                .getBean("SimpleHelloBean");
        SimpleHello.sayHello();

    }

}