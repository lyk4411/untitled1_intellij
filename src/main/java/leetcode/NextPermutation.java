package leetcode;

/**
 * Created by lyk on 2017/3/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{1,4,6,8,7,5,4};
        np.nextPermutation(nums);

        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
        np.nextPermutation(nums);

        for (int i : nums) {
            System.out.print(i);
        }

    }
    public void nextPermutation(int[] num) {
        //1.找到最后一个升序位置pos
        int pos = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        //System.out.println(pos);

        //2.如果不存在升序，即这个数是最大的，那么反排这个数组
        if (pos < 0) {
            reverse(num, 0, num.length - 1);
            return;
        }

        //3.存在升序，那么找到pos之后最后一个比它大的位置
        for (int i = num.length - 1; i > pos; i--) {
            if (num[i] > num[pos]) {
                int tmp = num[i];
                num[i] = num[pos];
                num[pos] = tmp;
                break;
            }
        }

        //4.反排pos之后的数
        reverse(num, pos + 1, num.length - 1);
    }

    public void reverse(int[] num, int begin, int end) {
        int l = begin, r = end;
        while (l < r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}
