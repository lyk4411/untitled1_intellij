package leetcode;

/**
 * Created by lyk on 2017/4/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII rdslii = new RemoveDuplicatesfromSortedListII();
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
        System.out.println(rdslii.deleteDuplicates(ln1));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
        }
        return t.next;
    }
}
