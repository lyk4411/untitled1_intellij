package leetcode;

import java.util.Random;

/**
 * Created by lyk on 2017/5/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        LinkedListRandomNode llrn = new LinkedListRandomNode(ln1);
        System.out.println(llrn.getRandom());
    }
    ListNode head;
    Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){

            c = c.next;
            if(random.nextInt(i + 1) == i) r = c.val;
        }

        return r;
    }
}
