package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2017/2/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KeyboardRow {
    public static void main(String[] args){
        KeyboardRow kr = new KeyboardRow();
        String[] words = {"hello","world","   ","12312","dad","tytweorquiweERRTR","VCCXVxv","dsafadf"};
        String[] results = kr.findWords(words);
        for(String result:results){
            System.out.println(result);
        }
    }
//    public String[] findWords(String[] words) {
//        //return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
//        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
//    }

    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        System.out.println(map);

        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.getOrDefault(w.toUpperCase().charAt(0),-1);
            for(char c: w.toUpperCase().toCharArray()){
                if(index == -1) break;
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
//        String[] array =new String[res.size()];
//        return res.toArray(array);
        return res.toArray(new String[0]);
    }
}
