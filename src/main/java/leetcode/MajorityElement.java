package leetcode;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = new int[]{1,1,1,2,2,2,2,1,2,2,1,1,1};
        System.out.println(me.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(count == 0){
                result = nums[ i ];
                count = 1;
            }else if(result == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return result;
    }
//    public int majorityElement(int[] num) {
//        if (num.length == 1) {
//            return num[0];
//        }
//
//        Arrays.sort(num);
//        return num[num.length / 2];
//    }
//        public int majorityElement(int[] num) {
//            if(num.length==1){
//                return num[0];
//            }
//
//            Arrays.sort(num);
//
//            int prev=num[0];
//            int count=1;
//            for(int i=1; i<num.length; i++){
//                if(num[i] == prev){
//                    count++;
//                    if(count > num.length/2) return num[i];
//                }else{
//                    count=1;
//                    prev = num[i];
//                }
//            }
//
//            return 0;
//        }
    }
