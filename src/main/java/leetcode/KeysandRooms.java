package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lyk on 2018-6-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

    public static void main(String[] args) {
        KeysandRooms kr = new KeysandRooms();
        List<List<Integer>> r1 = new ArrayList<>();
        List<List<Integer>> r2 = new ArrayList<>();
        List<Integer> r11 = new ArrayList<>();
        List<Integer> r12 = new ArrayList<>();
        List<Integer> r13 = new ArrayList<>();
        List<Integer> r14 = new ArrayList<>();
        r11.add(1);
        r12.add(2);
        r13.add(3);
        r1.add(0,r11);
        r1.add(1,r12);
        r1.add(2,r13);
        r1.add(3,r14);
        List<Integer> r21 = new ArrayList<>();
        List<Integer> r22 = new ArrayList<>();
        List<Integer> r23 = new ArrayList<>();
        List<Integer> r24 = new ArrayList<>();
        r21.add(0, 1);
        r21.add(1, 3);
        r22.add(0, 3);
        r22.add(1, 0);
        r22.add(2, 1);
        r23.add(2);
        r24.add(0);
        r2.add(0, r21);
        r2.add(0, r22);
        r2.add(0, r23);
        r2.add(0, r24);
        System.out.println(kr.canVisitAllRooms(r1));
        System.out.println(kr.canVisitAllRooms(r2));
    }
}
