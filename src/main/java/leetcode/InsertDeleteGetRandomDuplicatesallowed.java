package leetcode;

import java.util.*;

/**
 * Created by lyk on 2017/5/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class InsertDeleteGetRandomDuplicatesallowed {
    public static void main(String[] args) {
        InsertDeleteGetRandomDuplicatesallowed idrd =
                new InsertDeleteGetRandomDuplicatesallowed();
        System.out.println(idrd.insert(1));
        System.out.println(idrd.insert(2));
        System.out.println(idrd.insert(3));
        System.out.println(idrd.insert(1));
        System.out.println(idrd.list);
        System.out.println(idrd.getRandom());
        System.out.println(idrd.getRandom());
        System.out.println(idrd.getRandom());
    }
    Map<Integer, PriorityQueue<Integer>> map;
    List<Integer> list;
    Random random;
    public InsertDeleteGetRandomDuplicatesallowed() {
        map = new HashMap();
        list = new ArrayList();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else {
            map.put(val, new PriorityQueue<>((a, b) -> b - a));
            map.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int delete_index = map.get(val).peek();
        int last = list.get(list.size() - 1);
        // update
        list.set(delete_index, last);
        map.get(last).poll();
        map.get(last).add(delete_index);
        // delete
        list.remove(list.size() - 1);
        map.get(val).poll();
        if(map.get(val).size() == 0) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
