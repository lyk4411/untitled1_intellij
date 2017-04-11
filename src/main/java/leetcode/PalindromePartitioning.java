package leetcode;

import java.util.ArrayList;

/**
 * Created by lyk on 2017/4/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("hafehabahliuil"));
    }
//    图解在：https://leetcode.com/problems/palindrome-partitioning/#/solutions
//    if the input is "aab", check if [0,0] "a" is palindrome. then check [0,1] "aa", then [0,2] "aab".
//    While checking [0,0], the rest of string is "ab", use ab as input to make a recursive call.
//    enter image description here
//
//    in this example, in the loop of i=l+1, a recursive call will be made with input = "ab".
//            Every time a recursive call is made, the position of l move right.
//
//    How to define a correct answer?
//    Think about DFS, if the current string to be checked (Palindrome) contains the last position, in this case "c", this path is a correct answer, otherwise, it's a false answer.
//
//    enter image description here
//
//    line 13: is the boundary to check if the current string contains the last element.
//            l>=s.length()

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> partition = new ArrayList<String>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private void addPalindrome(String s, int start, ArrayList<String> partition,
                               ArrayList<ArrayList<String>> result) {
        //stop condition
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }



//    List<List<String>> resultLst;
//    ArrayList<String> currLst;
//
//    public List<List<String>> partition(String s) {
//        resultLst = new ArrayList<List<String>>();
//        currLst = new ArrayList<String>();
//        backTrack(s, 0);
//        return resultLst;
//    }
//
//    public void backTrack(String s, int l) {
//        if (currLst.size() > 0 //the initial str could be palindrome
//                && l >= s.length()) {
//            List<String> r = (ArrayList<String>) currLst.clone();
//            resultLst.add(r);
//        }
//        for (int i = l; i < s.length(); i++) {
//            if (isPalindrome(s, l, i)) {
//                if (l == i)
//                    currLst.add(Character.toString(s.charAt(i)));
//                else
//                    currLst.add(s.substring(l, i + 1));
//                backTrack(s, i + 1);
//                currLst.remove(currLst.size() - 1);
//            }
//        }
//    }
//
//    public boolean isPalindrome(String str, int l, int r) {
//        if (l == r) return true;
//        while (l < r) {
//            if (str.charAt(l) != str.charAt(r)) return false;
//            l++;
//            r--;
//        }
//        return true;
//    }
}

