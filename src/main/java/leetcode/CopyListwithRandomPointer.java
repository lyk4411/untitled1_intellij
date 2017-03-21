package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2017/3/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CopyListwithRandomPointer {
    public static void main(String[] args) {
        CopyListwithRandomPointer clrp = new CopyListwithRandomPointer();
        RandomListNode rln1 = new RandomListNode(1);
        RandomListNode rln2 = new RandomListNode(2);
        RandomListNode rln3 = new RandomListNode(3);
        RandomListNode rln4 = new RandomListNode(4);
        RandomListNode rln5 = new RandomListNode(5);
        RandomListNode rln6 = new RandomListNode(6);
        RandomListNode rln7 = new RandomListNode(7);
        RandomListNode rln8 = new RandomListNode(8);
        RandomListNode rln9 = new RandomListNode(9);
        rln1.next = rln2;
        rln2.next = rln3;
        rln3.next = rln4;
        rln4.next = rln5;
        rln5.next = rln6;
        rln6.next = rln7;
        rln7.next = rln8;
        rln8.next = rln9;
        rln1.random = rln3;
        rln2.random = rln4;
        rln3.random = rln5;
        rln4.random = rln6;
        rln5.random = rln7;
        rln6.random = rln8;
        rln7.random = rln9;
        rln8.random = rln1;
        rln9.random = null;
        System.out.println(rln1);
        RandomListNode result = clrp.copyRandomList(rln1);
        System.out.println(result);
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        return  ":" + label + (random != null?random.toString():"") ;
    }
}