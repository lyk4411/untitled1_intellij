package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3,1));
        System.out.println(ps.getPermutation(3,2));
        System.out.println(ps.getPermutation(3,3));
    }
//    方法二：数学解法
//
//    在n!个排列中，第一位的元素总是(n-1)!一组出现的，也就说如果p = k / (n-1)!，那么排列的最开始一个元素一定是nums[p]。
//
//    假设有n个元素，第K个permutation是
//    a1, a2, a3, .....   ..., an
//    那么a1是哪一个数字呢？
//    那么这里，我们把a1去掉，那么剩下的permutation为
//    a2, a3, .... .... an, 共计n-1个元素。 n-1个元素共有(n-1)!组排列，那么这里就可以知道
//            设变量K1 = K
//    a1 = K1 / (n-1)!
//    同理，a2的值可以推导为
//            a2 = K2 / (n-2)!
//    K2 = K1 % (n-1)!
//            .......
//    a(n-1) = K(n-1) / 1!
//    K(n-1) = K(n-2) /2!
//    an = K(n-1)
public String getPermutation(int n, int k) {
    List<Integer> num = new LinkedList<Integer>();
    for (int i = 1; i <= n; i++) num.add(i);
    int[] fact = new int[n];  // factorial
    fact[0] = 1;
    for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
    k = k-1;
    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--){
        int ind = k/fact[i-1];
        k = k%fact[i-1];
        sb.append(num.get(ind));
        num.remove(ind);
    }
    return sb.toString();
}


//
//    public String getPermutation(int n, int k) {
//        NextPermutation np = new NextPermutation();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i + 1;
//        }
//        for (int i = 0; i < k; i++) {
//            np.nextPermutation(nums);
//        }
//        String string = Arrays.toString(nums);
//        string = string.replace(",","");
//        string = string.replace("[","");
//        string = string.replace("]","");
//        string = string.replace(" ","");
//        return string;
//    }
}
