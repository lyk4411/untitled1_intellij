package leetcode;

import java.util.HashMap;

/**
 * Created by lyk on 2017/3/29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("egg","add"));
        System.out.println(is.isIsomorphic("foo","bar"));
        System.out.println(is.isIsomorphic("paper","title"));
    }
    public boolean isIsomorphic(String s1, String s2) {
        HashMap<String,String> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(hm.containsKey(s1.substring(i,i+1))){
                String temp = hm.get(s1.substring(i,i+1));
                if(!temp.equals(s2.substring(i,i+1))){
                    return false;
                }
            }else if(hm.containsValue(s2.substring(i,i+1))){
                return false;
            } else {
                hm.put(s1.substring(i,i+1),s2.substring(i,i+1));
            }
        }
        return true;
    }
//    public boolean isIsomorphic(String s, String t) {
//        if(s==null||t==null)
//            return false;
//
//        if(s.length()!=t.length())
//            return false;
//
//        HashMap<Character, Character> map = new HashMap<Character, Character>();
//
//        for(int i=0; i<s.length(); i++){
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//
//            if(map.containsKey(c1)){
//                if(map.get(c1)!=c2)// if not consistant with previous ones
//                    return false;
//            }else{
//                if(map.containsValue(c2)) //if c2 is already being mapped
//                    return false;
//                map.put(c1, c2);
//            }
//        }
//
//        return true;
//    }
}
