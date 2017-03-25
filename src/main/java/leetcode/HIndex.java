package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] citations = new int[]{1,2,3,4,0,6,3,2,5,1,1,1};
        System.out.println(hi.hIndex(citations));
    }
    public int hIndex(int[] citations)
    {
        int h = 0;

        if(null == citations)
        {
            return h;
        }
        //我的解法是按照频次从小到大排列。之后需要从后向前遍历。只是方向发生了改变，不影响结果。
        Arrays.sort(citations);

        for(int loc = citations.length - 1; loc >= 0 && citations[loc] >= (citations.length - loc) ; --loc)
        {
            h = citations.length - loc;
        }

        return h;
    }
}
