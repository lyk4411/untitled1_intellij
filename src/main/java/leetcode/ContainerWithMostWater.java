package main.java.leetcode;

/**
 * Created by liuyongkai on 17/3/12.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = new int[]{1,2,3,4,5,6,7,8,9,0,0,0,0,2,3,4,5,6,5,4,3,2};
        System.out.println(containerWithMostWater.maxArea(height));
    }
    public int maxArea(int[] height) {
        {
            int left = 0, right = height.length - 1;
            int maxArea = 0;
            while (left < right && left >= 0 && right <= height.length - 1) {
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return maxArea;
        }
    }
}
