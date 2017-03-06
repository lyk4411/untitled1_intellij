package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isValidPalindrome("Red rum, sir, is murder"));
        System.out.println(vp.isValidPalindrome("Red rum,"));
    }

    public static boolean isValidPalindrome(String s){
        if(s==null||s.length()==0) return false;

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int len = s.length();
        if (len < 2)
            return true;

        Stack<Character> stack = new Stack<Character>();

        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }

        if (len % 2 == 1)
            index++;

        while (index < len) {
//            if (stack.empty())
//                return false;

            char temp = stack.pop();
            if (s.charAt(index) != temp)
                return false;
            else
                index++;
        }
        return true;
    }
}
