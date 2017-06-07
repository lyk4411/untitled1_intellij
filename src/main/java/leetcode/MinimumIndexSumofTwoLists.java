package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumIndexSumofTwoLists {
    public static void main(String[] args) {
        MinimumIndexSumofTwoLists mistl = new MinimumIndexSumofTwoLists();
        String[] list1 = new String[4];
        String[] list2 = new String[4];
        list1[0]="Shogun";
        list1[1]="Tapioca ";
        list1[2]="Burger King";
        list1[3]="KFC";
        list2[0]="KFC";
        list2[1]="Hungry ";
        list2[2]="Steakhouse";
        list2[3]="Shogun";

        String[] result = mistl.findRestaurant(list1,list2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i=0;i<list1.length;i++) map.put(list1[i], i);
        for (int i=0;i<list2.length;i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) { res = new LinkedList<>(); minSum = i+j; }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
