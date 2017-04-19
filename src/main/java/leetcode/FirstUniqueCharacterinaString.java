package leetcode;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FirstUniqueCharacterinaString {
    public static void main(String[] args) {
        FirstUniqueCharacterinaString fucs = new FirstUniqueCharacterinaString();
        System.out.println(fucs.firstUniqChar("abacdefhklafjaogan"));
        System.out.println(fucs.firstUniqChar("helloworld"));

    }
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
