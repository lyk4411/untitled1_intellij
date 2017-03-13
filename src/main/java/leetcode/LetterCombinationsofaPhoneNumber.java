package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuyongkai on 17/3/12.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        System.out.println(lcpn.letterCombinations("1234"));
    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        if(ans.peek().length()==0){
            return new LinkedList<String>();
        }
        return ans;
    }
}