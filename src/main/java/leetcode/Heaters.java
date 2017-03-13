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
        int[] hourses = new int[]{1,2,3,4,5,6,7,11};
        int[] heater1 = new int[]{1,8};
        int[] heater2 = new int[]{1};
        int[] heater3 = new int[]{1,1};
        int[] heater4 = new int[]{5};

        System.out.println(heaters.findRadius(hourses,heater1));
        System.out.println(heaters.findRadius(hourses,heater2));
        System.out.println(heaters.findRadius(hourses,heater3));
        System.out.println(heaters.findRadius(hourses,heater4));

    }
//    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//
//        int i = 0, j = 0, res = 0;
//        while (i < houses.length) {
//            while (j < heaters.length - 1
//                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
//                j++;
//            }
//            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
//            i++;
//        }
//
//        return res;
//    }
    public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int result = 0;
            int temp = 0;
            int j = 0;
            for (int i = 0; i < houses.length; i++) {
                while (j < heaters.length && heaters[j] < houses[i])
                    j++;
                if (j == heaters.length)
                    temp = houses[i] - heaters[j - 1];
                else if (j == 0)
                    temp = heaters[j] - houses[i];
                else if (heaters[j] > houses[i])
                    temp = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
                if (temp > result)
                    result = temp;
            }
            return result;
        }
    }
