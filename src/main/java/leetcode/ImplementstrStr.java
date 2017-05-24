package leetcode;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */

public class ImplementstrStr {

    public static void main(String[] args) {
        ImplementstrStr is = new ImplementstrStr();
        //System.out.println(is.strStr("ababcaababcaabc","ababcaabc"));
        //System.out.println(is.strStr("mississippi","a"));
        System.out.println(is.strStr("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
    }

    // http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html


    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        // 得到next数组
        getNextArr(next, needle);

        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " = ");
        }
        System.out.println();

        // i是匹配串haystack的指针，j是模式串needle的指针
        int i = 0, j = 0;
        // 双指针开始匹配
        while(i < haystack.length() && j < needle.length()){
            // 如果j=-1意味着刚刚失配过，下标+1后，下一轮就可以开始匹配各自的第一个了
            // 如果指向的字母相同，则下一轮匹配各自的下一个
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                // 如果失配，则将更新j为next[j]
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private void getNextArr(int[] next, String needle){
        // k是前缀中相同部分的末尾，同时也是相同部分的长度，因为长度等于k-0。
        // j是后缀的末尾，即后缀相同部分的末尾
        int k = -1, j = 0;
        next[0] = -1;
        while(j < needle.length() - 1){
            // 如果k=-1，说明刚刚失配了，则重新开始计算前缀和后缀相同的长度
            // 如果两个字符相等，则在上次前缀和后缀相同的长度加1就行了
            if (k == -1 || needle.charAt(j) == needle.charAt(k)){
                k++;
                j++;
                next[j] = k;
            } else {
                // 否则，前缀长度缩短为next[k]
                k = next[k];
            }
        }
    }



//    public int strStr(String haystack, String needle) {
//        if(haystack==null || needle==null)
//            return 0;
//
//        if(needle.length() == 0)
//            return 0;
//
//        for (int i = 0; i <haystack.length() ; i++) {
//            if(i+needle.length() > haystack.length()){
//                return  -1;
//            }
//
//            int m = i;
//            for (int j = 0; j < needle.length(); j++) {
//                if(needle.charAt(j)==haystack.charAt(m)){
//                    if(j==needle.length()-1){
//                        return i;
//                    }
//                    m++;
//                } else {
//                    break;
//                }
//            }
//        }
//        return -1;
//    }
}
