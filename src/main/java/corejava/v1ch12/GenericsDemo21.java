package corejava.v1ch12;

/**
 * Created by lyk on 2018-8-28.
 * Package name: corejava.v1ch12
 * Porject name: untitled1
 */




public class GenericsDemo21{
    static class Info<T>{
        private T var ;		// 定义泛型变量
        public void setVar(T var){
            this.var = var ;
        }
        public T getVar(){
            return this.var ;
        }
        public String toString(){	// 直接打印
            return this.var.toString() ;
        }
    }
    public static void main(String args[]){
        Info<String> i1 = new Info<String>() ;		// 声明String的泛型对象
        Info<Object> i2 = new Info<Object>() ;		// 声明Object的泛型对象
        i1.setVar("hello") ;
        i2.setVar(new Object()) ;
        fun(i1) ;
        fun(i2) ;
    }
    public static void fun(Info<? super String> temp){	// 只能接收String或Object类型的泛型
        System.out.print(temp + "、") ;
    }
}