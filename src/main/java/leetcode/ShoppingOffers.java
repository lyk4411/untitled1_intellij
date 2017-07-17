package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/7/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ShoppingOffers {
    public static void main(String[] args) {
        ShoppingOffers so = new ShoppingOffers();
        List<Integer> price = new ArrayList<>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        price.add(0,5);
        price.add(0,2);
        needs.add(0,2);
        needs.add(0,3);
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        s1.add(0,5);
        s1.add(0,0);
        s1.add(0,3);
        s2.add(0,10);
        s2.add(0,2);
        s2.add(0,1);
        special.add(0,s2);
        special.add(0,s1);
        System.out.println(so.shoppingOffers(price,special,needs));
    }

    public int shoppingOffers(List< Integer > price,
                              List < List < Integer >> special, List < Integer > needs) {
        return shopping(price, special, needs, 0);
    }
    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, int i) {
        if (i == special.size())
            return dot(needs, price);
        ArrayList < Integer > clone = new ArrayList< >(needs);
        int j = 0;
        for (j = 0; j < special.get(i).size() - 1; j++) {
            int diff = clone.get(j) - special.get(i).get(j);
            if (diff < 0)
                break;
            clone.set(j, diff);
        }
        if (j == special.get(i).size() - 1)
            return Math.min(special.get(i).get(j) + shopping(price, special, clone, i), shopping(price, special, needs, i + 1));
        else
            return shopping(price, special, needs, i + 1);
    }
    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}
