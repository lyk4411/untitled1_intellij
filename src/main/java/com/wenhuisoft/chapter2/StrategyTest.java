package com.wenhuisoft.chapter2;

/**
 * Created by lyk on 2016/7/5.
 */

/**
 * 策略接口，主要是规范或者让结构程序知道如何进行调用
 */
interface CalcStrategy {
    int calc(int x, int y);
}

/**
 * 程序的结构，里面约束了整个程序的框架和执行的大概流程，但并未涉及到业务层面的东西 * 只是将一个数据如何流入如何流出做了规范，只是提供了一个默认的逻辑实现 * @author Administrator
 */
class Calculator {
    private int x = 0;
    private int y = 0;
    private CalcStrategy strategy = null;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Calculator(int x, int y, CalcStrategy strategy) {
        this(x, y);
        this.strategy = strategy;

    }

    public int calc(int x, int y) {
        return x + y;
    }

    /**
     * 只需关注接口，并且将接口用到的入参传递进去即可，并不关心到底具体是要如何进行业务封装 * @return
     */
    public int result() {
        if (null != strategy) {
            return strategy.calc(x, y);
        }
        return calc(x, y);
    }
}

class AddStrategy implements CalcStrategy {
    public int calc(int x, int y) {
        return x + y;
    }
}

class SubStrategy implements CalcStrategy {
    public int calc(int x, int y) {
        return x - y;
    }
}

public class StrategyTest {
    public static void main(String[] args) { //没有任何策略时的结果
        Calculator c = new Calculator(30, 24);
        System.out.println(c.result());
        //传入减法策略的结果
        Calculator c1 = new Calculator(10, 30, new SubStrategy());
        System.out.println(c1.result());
        // 看到这里就可以看到策略模式强大了，算法可以随意设置，系统的结构并不会发生任何变化
        Calculator c2 = new Calculator(30, 40, new CalcStrategy() {
            public int calc(int x, int y) {
                return ((x + 10) - (y * 3)) / 2;
            }
        });
        System.out.println(c2.result());
    }
}