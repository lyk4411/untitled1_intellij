package leetcode;

/**
 * Created by lyk on 2017/6/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        CreateMaximumNumber cmn = new CreateMaximumNumber();
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        //int[] results = cmn.maxNumber(nums1,nums2,5);
//        for (int result : results) {
//            System.out.print(result + "  :  ");
//        }
        System.out.println();

        int[] temps = cmn.maxArray(nums2,4);
        for (int temp : temps) {
            System.out.print(temp + "  :  ");
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        //分别从nums1和nums2数组中抽取0-k个数字
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    //merge两个子数组
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    //从数组nums中选择k个组成最大数组，选出的数字顺序不变。
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
//        List<Integer> temp = new ArrayList<Integer>();
//        for (int i = 0; i < k && i < nums.length; i++) {
//            temp.add(nums[i]);
//        }
        //System.out.println("temp: " + temp);

//        if(nums.length > k) {
//            for (int i = k; i < nums.length; i++){
//                for (int j = 0; j < k; j++) {
//                    if(nums[i] > temp.get(j)){
//                        temp.remove(j);
//                        //System.out.println("temp: " + temp + "   j:" + j);
//                        temp.add(nums[i]);
//                        //System.out.println("temp: " + temp + "   num[i]:" + nums[i]);
//                        break;
//                    }
//                }
//            }
//        }
//        for(int i = 0;i<temp.size();i++){
//            ans[i] = temp.get(i);
//        }
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
