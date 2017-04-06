package leetcode;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ReverseNodesinkGroup {
    public static void main(String[] args) {
        ReverseNodesinkGroup rng = new ReverseNodesinkGroup();
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
        System.out.println(rng.reverseKGroup(ln1,2));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i=0;

        ListNode p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                pre = reverse(pre, p.next);
                p = pre.next;
            }else{
                p = p.next;
            }
        }

        return fake.next;
    }

    /*
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     *
     * after calling pre = reverse(pre, next)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     */
    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }

        return last;
    }
}
