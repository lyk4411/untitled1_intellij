package leetcode;

/**
 * Created by lyk on 2017/4/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aa","aab"));
        System.out.println(rn.canConstruct("aa","ab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
