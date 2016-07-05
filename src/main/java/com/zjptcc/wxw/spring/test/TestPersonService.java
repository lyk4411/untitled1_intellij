package com.zjptcc.wxw.spring.test;

/**
 * Created by lyk on 2016/7/5.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjptcc.wxw.spring.person.PersonService;

public class TestPersonService {

    /**
     * @param args
     */
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        ctx = new ClassPathXmlApplicationContext("person-beans.xml");

        PersonService p = (PersonService) ctx
                .getBean("personService");
        p.info();
        System.out.println(p.getName());

    }

}