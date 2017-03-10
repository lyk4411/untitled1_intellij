package leetcode;

import java.util.Arrays;
/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Heaters {
    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        int[] hourses = new int[]{1,2,3,4,5,6,7,8};
        int[] heater = new int[]{1,4};
        System.out.println(heaters.findRadius(hourses,heater));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
