package example;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lyk on 2017/3/2.
 * Package name: example
 * Porject name: untitled1
 */

public class Test10 {
    public static void main(String[] args) {

        //
        ArrayList<String> arrayList1=new ArrayList();
        arrayList1.add("1");//编译通过
        //arrayList1.add(1);//编译错误
        String str1=arrayList1.get(0);//返回类型就是String

        ArrayList arrayList2=new ArrayList<String>();
        arrayList2.add("1");//编译通过
        arrayList2.add(1);//编译通过
        Object object=arrayList2.get(0);//返回类型就是Object

        new ArrayList<String>().add("11");//编译通过
        //new ArrayList<String>().add(22);//编译错误
        //String string=new ArrayList<String>().get(0);//返回类型就是String
    }
    public  static <T extends Comparable> T[] minmax(T[] a){
        T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(),2);
        return mm;
    }


}
