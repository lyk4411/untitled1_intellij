package leetcode;

import java.util.TreeMap;

/**
 * Created by lyk on 2018-7-4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int card: hand) {
            if (!count.containsKey(card))
                count.put(card, 1);
            else
                count.replace(card, count.get(card) + 1);
        }

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; ++card) {
                if (!count.containsKey(card)) return false;
                int c = count.get(card);
                if (c == 1) count.remove(card);
                else count.replace(card, c - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandofStraights hs = new HandofStraights();
        System.out.println(hs.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(hs.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(hs.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
