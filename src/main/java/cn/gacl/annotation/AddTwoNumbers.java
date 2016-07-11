package cn.gacl.annotation;


/**
 * Created by lyk on 2016/7/7.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;

        while (p1 != null || p2 != null || carry != 0) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            int digit = carry % 10;
            System.out.println(digit);
            p3.next = new ListNode(digit);
            p3 = p3.next;
            carry /= 10;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode a1 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode c1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;
        ListNode result = addTwoNumbers(a, a1);
        System.out.println("==================================================");
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result.next != null);
        System.out.println(result.val);


    }
}
