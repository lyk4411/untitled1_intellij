package leetcode;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(fpe.findPeakElement(nums));
    }
    public int findPeakElement(int[] num) {
        int max = num[0];
        int index = 0;
        for(int i=1; i<=num.length-2; i++){
            int prev = num[i-1];
            int curr = num[i];
            int next = num[i+1];

            if(curr > prev && curr > next && curr > max){
                index = i;
                max = curr;
            }
        }

        if(num[num.length-1] > max){
            return num.length-1;
        }

        return index;
    }


//    O(logN) Solution JavaCode
//
//    This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.
//
//    If num[i-1] < num[i] > num[i+1], then num[i] is peak
//    If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
//    If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
//    If num[i-1] > num[i] < num[i+1], then both sides have peak
//            (n is num.length)
//
//    Here is the code
//    public int findPeakElement(int[] num) {
//        int max = num[0];
//        int index = 0;
//        for(int i=1; i<=num.length-2; i++){
//            int prev = num[i-1];
//            int curr = num[i];
//            int next = num[i+1];
//
//            if(curr > prev && curr > next && curr > max){
//                index = i;
//                max = curr;
//            }
//        }
//
//        if(num[num.length-1] > max){
//            return num.length-1;
//        }
//
//        return index;
//    }
}
