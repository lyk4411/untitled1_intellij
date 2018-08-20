package corejava.v2ch10.PropertyLea;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyk on 2018-8-20.
 * Package name: corejava.v2ch10.PropertyLea
 * Porject name: untitled1
 */
public class PropertyTracker {
    public static void trackerProperty(List<Integer> ids, Class cls){
        for (Method method : cls.getDeclaredMethods()){
            Property annot = method.getAnnotation(Property.class);
            if (annot != null){
                System.out.println("The Annotation's id is: " + annot.id() + " msg is: " + annot.msg() + ", methiod is:" + method);
                ids.remove(new Integer(annot.id()));
            }else {
                System.out.println("This method doesn't has Annotation - Property!");
            }
        }

        for (Integer i : ids){
            System.out.println("Warning! Missing Property - " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> propertys = new ArrayList<>(5);
        Collections.addAll(propertys, 1, 2, 3, 4, 5);
        trackerProperty(propertys, Goods.class);
    }

}
