package leetcode;

/**
 * Created by lyk on 2018-8-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleoftheLinkedList mll = new MiddleoftheLinkedList();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;

        System.out.println(mll.middleNode(h1));
        System.out.println(mll.middleNode(h2));
        System.out.println(mll.middleNode(h3));

    }
}
