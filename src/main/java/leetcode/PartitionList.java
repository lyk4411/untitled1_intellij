package leetcode;

/**
 * Created by lyk on 2017/3/16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(5);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(7);
        ListNode ln5 = new ListNode(2);
        ListNode ln6 = new ListNode(9);
        ListNode ln7 = new ListNode(4);
        ListNode ln8 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        System.out.println(pl.partition(ln1,5));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
