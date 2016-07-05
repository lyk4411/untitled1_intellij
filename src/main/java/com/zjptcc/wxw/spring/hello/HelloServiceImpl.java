package com.zjptcc.wxw.spring.hello;

/**
 * Created by lyk on 2016/7/5.
 */


public class HelloServiceImpl implements IHelloService {
    private String Hello;
    private String ChinaHello;

    @Override
    public void sayHello() {
        // TODO 自动生成的方法存根
        System.out.println(Hello);
    }

    @Override
    public void sayChinaHello() {
        // TODO 自动生成的方法存根
        System.out.println(ChinaHello);
    }

    public String getHello() {
        return Hello;
    }

    public void setHello(String hello) {
        Hello = hello;
    }

    public String getChinaHello() {
        return ChinaHello;
    }

    public void setChinaHello(String chinaHello) {
        ChinaHello = chinaHello;
    }

}