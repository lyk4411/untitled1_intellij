package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/7/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DesignLogStorageSystem {
    public static void main(String[] args) {
        DesignLogStorageSystem dlss = new DesignLogStorageSystem();
        dlss.put(1,"2017:06:06:06:06:06");
        dlss.put(2,"2017:07:07:07:07:07");
        System.out.println(dlss.retrieve("2017:06:07:06:06:06","2017:09:06:06:06:06","Day"));
        System.out.println(dlss.retrieve("2017:06:07:06:06:06","2017:09:06:06:06:06","Month"));
        System.out.println(dlss.retrieve("2017:06:07:06:06:06","2017:09:06:06:06:06","Year"));
    }
    List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4,7,10,13,16,19};

    public void put(int id, String timestamp) {
        timestamps.add(new String[]{Integer.toString(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new LinkedList<>();
        int idx = indices[units.indexOf(gra)];
        for (String[] timestamp : timestamps) {
            if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
                    timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0)
                res.add(Integer.parseInt(timestamp[0]));
        }
        return res;
    }
}
