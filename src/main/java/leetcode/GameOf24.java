package leetcode;

import java.util.ArrayList;

/**
 * Created by lyk on 2018-6-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GameOf24 {
    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
        return solve(A);
    }
    private boolean solve(ArrayList<Double> nums) {

        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int m = 0; m < nums.size(); m++) {
                        if (m != i && m != j) {
                        nums2.add(nums.get(m));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GameOf24 gameOf24 = new GameOf24();
//        System.out.println(gameOf24.judgePoint24(new int[]{4, 1, 8, 7}));
//        System.out.println(gameOf24.judgePoint24(new int[]{8, 3, 3, 4}));
//        System.out.println(gameOf24.judgePoint24(new int[]{8, 3, 3, 5}));
//        System.out.println(gameOf24.judgePoint24(new int[]{8, 3, 8, 5}));
//        System.out.println(gameOf24.judgePoint24(new int[]{1, 5, 5, 5}));
//        System.out.println(gameOf24.judgePoint24(new int[]{1, 3, 8, 3}));
        System.out.println(gameOf24.judgePoint24(new int[]{8, 8, 8, 8}));
        System.out.println(gameOf24.judgePoint24(new int[]{6, 6, 4, 2}));
        System.out.println(gameOf24.judgePoint24(new int[]{2, 2, 1, 9}));

    }
}
