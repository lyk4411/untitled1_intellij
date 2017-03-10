package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        FindAllAnagramsinaString faas = new FindAllAnagramsinaString();
        List<Integer> list = faas.findAnagrams("abcdefabcdefabcdefabcdefaaa","abc");
        System.out.println(list);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int NumberOfDeference = p.length();  //差异度指数
        int left=0,right=0;  //窗口左右指针
        int[] asciiChars = new int[256];//记录p中字符有哪些及其数量的数组
        for (int i = p.length() - 1; i>=0; --i)
        {     ++asciiChars[p.charAt(i)];      } //记录完毕

//        for (int i = 0; i < asciiChars.length; i++) {
//            System.out.print(":" + asciiChars[i]);
//        }
//        System.out.println();

        for(;right<s.length();right++){  //滑动右窗口
            asciiChars[s.charAt(right)]--;  //在该字符相应位置减一
            if(asciiChars[s.charAt(right)]>=0) NumberOfDeference--; //如果加进来的那个在p中，NumberOfDeference减一
            if(right-left == (p.length()-1)){  //如果这时窗口大小为p.length()
                if(NumberOfDeference==0) result.add(left);//这时出现一次匹配，将左窗口加到result中
                //下面是滑动左窗口的操作
                if(asciiChars[s.charAt(left)]>=0) {
                    NumberOfDeference++;//如果被踢出的那个在p中，NumberOfDeference加一
                }
                asciiChars[s.charAt(left)]++;//数组中相应字符计数位置加回来
                left++; //左窗口向右滑动
            }
        }
        return result;
    }
}
