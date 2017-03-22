package leetcode;

/**
 * Created by lyk on 2017/3/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
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
        ln7.next = ln8;
        System.out.println(isl.insertionSortList(ln1));
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode next = cur.next;
            pre = helper;
            while(pre.next!=null && pre.next.val<cur.val)
            {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}
