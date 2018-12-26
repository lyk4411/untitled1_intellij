package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-12-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        BoatstoSavePeople bsp = new BoatstoSavePeople();
        System.out.println(bsp.numRescueBoats(
                new int[]{1, 2}, 3));
        System.out.println(bsp.numRescueBoats(
                new int[]{3, 2, 2, 1}, 3));
        System.out.println(bsp.numRescueBoats(
                new int[]{3, 5, 3, 4}, 5));
    }
}
