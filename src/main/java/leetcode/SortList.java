package leetcode;

/**
 * Created by lyk on 2017/3/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SortList {
    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode ln1 = new ListNode(10);
        ListNode ln2 = new ListNode(6);
        ListNode ln3 = new ListNode(7);
        ListNode ln4 = new ListNode(8);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(9);
        ListNode ln7 = new ListNode(4);
        ListNode ln8 = new ListNode(2);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        System.out.println(ln1);
        System.out.println(sl.sortList(ln1));
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}
