package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"acb","cab","bca","bac"
                ,"def","ed","de","edf"};
        System.out.println(ga.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            // 将单词按字母排序
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        // 将列表按单词排序
        for(String key : map.keySet()){
            List<String> curr = map.get(key);
            Collections.sort(curr);
            res.add(curr);
        }
        return res;
    }
}
