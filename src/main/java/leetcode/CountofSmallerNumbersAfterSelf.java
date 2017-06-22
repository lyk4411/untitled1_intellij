package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/6/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf csnas = new CountofSmallerNumbersAfterSelf();
        int[] nums = new int[]{5,2,6,1};
        System.out.println(csnas.countSmaller(nums));
    }

    //思路: 有两种思路可以做，第一种是从右往左遍历数组，并且将搜索过的数有序的放到一个数组中，
    // 然后每次从这个维护的数组中找到第一个大于当前元素的位置即可直到右边有多少个数比他小了．
    // 这种方式的时间复杂度是O(n^2)，因为数组插入元素的时间复杂度是O(n)（因为需要移位）．
    // 简单粗暴．虽然这种方法比朴素的O(n^2)有所优化, 但是本质上还是一样的, 我并不认为这个方法
    // 可以满足要求.

//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] ans = new Integer[nums.length];
//        List<Integer> sorted = new ArrayList<Integer>();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            int index = findIndex(sorted, nums[i]);
//            ans[i] = index;
//            sorted.add(index, nums[i]);
//        }
//        return Arrays.asList(ans);
//    }
//    private int findIndex(List<Integer> sorted, int target) {
//        if (sorted.size() == 0) return 0;
//        int start = 0;
//        int end = sorted.size() - 1;
//        if (sorted.get(end) < target) return end + 1;
//        if (sorted.get(start) >= target) return 0;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (sorted.get(mid) < target) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//        if (sorted.get(start) >= target) return start;
//        return end;
//    }


    //第二种方式是利用归并排序，其实就像是求逆序数一样．在将左右两半数组都排
    // 序之后，可以对左边数组中的每一个数在右边数组中找到有多少比他小的数．归并
    // 排序有很多额外的用途．这种方法的时间复杂度是O(nlog(n))．但是有点意外的
    // 是第一种效率比第二种还高一点，可能第二种的常量系数比较大吧．其实第二种还
    // 有一点可以优化，就是可以再用二分查找来找到第一个大于左边的数．但是不知道
    // 能优化多少．
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }
    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }
}

