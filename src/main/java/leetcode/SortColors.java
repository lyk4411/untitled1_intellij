package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SortColors {
    public  static  void main(String[] args) {
        SortColors sc = new SortColors();
        int[] as = new int[]{1,2,1,2,1,1,1,0,0,0,0,0,2,2,2,1};
        sc.sortColors(as);
        for(int a: as){
            System.out.println(a);
        }
    }
    public void sortColors(int[] nums) {
        int i, r, w, b;
        r = w = b = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) r++;
            else  if (nums[i] == 1) w++;
            else b++;
        }
        for (i = 0; i < nums.length; i++) {
            if (i < r) nums[i] = 0;
            else if (i < r + w) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
