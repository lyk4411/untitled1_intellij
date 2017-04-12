package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/4/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> list = new ArrayList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(wb.wordBreak("leetcode",list));
    }
    public boolean wordBreak(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
