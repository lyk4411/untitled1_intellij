package leetcode;

/**
 * Created by lyk on 2017/3/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveDuplicatesfromSortedList {
    public static  void  main(String[] args) {
        RemoveDuplicatesfromSortedList rdfsl = new RemoveDuplicatesfromSortedList();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(1);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(2);
        ListNode ln5 = new ListNode(2);
        ListNode ln6 = new ListNode(3);
        ListNode ln7 = new ListNode(4);
        ListNode ln8 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ListNode result = rdfsl.deleteDuplicates(ln1);
        while (result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        for (ListNode pre = head, node = head.next; node != null;) {
            if (node.val == pre.val) {
                pre.next = node.next;
                node = node.next;
                continue;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }

    @Override
    public String toString() {
        return ":" + val + ":" + (next !=null? next.toString(): "");
    }
}
