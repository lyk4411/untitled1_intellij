package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2017/5/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DistributeCandies {
    public static void main(String[] args) {
        DistributeCandies ds = new DistributeCandies();
        int[] candies1 = new int[]{1,1,1,2,2,3};
        int[] candies2 = new int[]{1,1,1,2,2,3,4,4};
        System.out.println(ds.distributeCandies(candies1));
        System.out.println(ds.distributeCandies(candies2));
    }
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}
