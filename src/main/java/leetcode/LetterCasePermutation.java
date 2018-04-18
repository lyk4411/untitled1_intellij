package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        Queue<String> r = new LinkedList<>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {//分析字符串每一个字符
            char c = S.charAt(i);
            if (Character.isLetter(c)) {//如果该字符为英文字符，继续执行
                int size = r.size();
                for (int j = 0; j < size; j++) {//队列内存放目前为止各种情况
                    String s = r.poll();//每一次弹出一个保存的String
                    r.add(s.substring(0, i) + Character.toLowerCase(c) + s.substring(i + 1));
                    r.add(s.substring(0, i) + Character.toUpperCase(c) + s.substring(i + 1));
                    //弹出后将该字符串的当前位置字符分别替换为大小写，保存到队列中
                }
            }
        }
        return (List)r;
    }

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        String s1 = new String("a1b2");
        String s2 = new String("3z4");
        String s3 = new String("12345");
        System.out.println(lcp.letterCasePermutation(s1));
        System.out.println(lcp.letterCasePermutation(s2));
        System.out.println(lcp.letterCasePermutation(s3));

    }
}
