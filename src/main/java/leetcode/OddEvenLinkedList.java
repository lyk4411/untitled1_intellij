package leetcode;

/**
 * Created by lyk on 2017/4/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedList oell = new OddEvenLinkedList();
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
        System.out.println(oell.oddEvenList(ln1));
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode result = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;

        while(p1 != null && p2 != null){
            ListNode t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }
}
