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
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
