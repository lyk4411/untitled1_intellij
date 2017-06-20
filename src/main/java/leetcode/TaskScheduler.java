package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks = new char[]{'A','B','C','D','E','A','B','C','D','E','A','B','C','D','E'};
        System.out.println(ts.leastInterval(tasks,2));
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
                (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        q.addAll(map.entrySet());

        int count = 0;
        while (!q.isEmpty()) {
            int k = n + 1;
            List<Map.Entry> tempList = new ArrayList<>();
            while (k > 0 && !q.isEmpty()) {
                Map.Entry<Character, Integer> top = q.poll(); // most frequency task
                top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
                tempList.add(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0) q.add(e); // add valid tasks
            }

            if (q.isEmpty()) break;
            count = count + k; // if k > 0, then it means we need to be idle
        }
        return count;
    }
}
