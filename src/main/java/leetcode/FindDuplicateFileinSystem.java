package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindDuplicateFileinSystem {
    public static void main(String[] args) {
        FindDuplicateFileinSystem fdfs = new FindDuplicateFileinSystem();
        String[] paths = new String[6];
        paths[0]= "root/a 1.txt(abcd) 2.txt(efgh)";
        paths[1]= "root/c 3.txt(abcd)";
        paths[2]= "root/c/d 4.txt(efgh)";
        paths[3]= "root 4.txt(efgh)";
        paths[4]= "";
        paths[5]= "";
        System.out.println(fdfs.findDuplicate(paths));
    }
    public  List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] tokens = path.split(" ");
            for(int i = 1; i < tokens.length; i++) {
                String file = tokens[i].substring(0, tokens[i].indexOf('('));
                String content = tokens[i].substring(tokens[i].indexOf('(') + 1, tokens[i].indexOf(')'));
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(tokens[0] + "/" + file);
            }
        }
        return map.values().stream().filter(e -> e.size() > 1).collect(Collectors.toList());
    }
}
