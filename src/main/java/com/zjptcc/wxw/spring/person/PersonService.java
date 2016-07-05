package com.zjptcc.wxw.spring.person;

/**
 * Created by lyk on 2016/7/5.
 */

public class PersonService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void info(){
        System.out.println("此人姓名为："+name);
    }

    public String getName(){
        return name;
    }
}