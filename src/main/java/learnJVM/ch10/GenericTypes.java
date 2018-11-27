package learnJVM.ch10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-11-27.
 * Package name: learnJVM.ch10
 * Porject name: untitled1
 */

public class GenericTypes {

//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }

    public static int method(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list)");
        return 1;
    }

    public static void main(String[] args) {
//        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }
}

