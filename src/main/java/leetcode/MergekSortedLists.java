package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MergekSortedLists {
    public static void main(String[] args) {
        MergekSortedLists msl = new MergekSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

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
        ListNode[] lns = new ListNode[]{l1,ln1};
        System.out.println(msl.mergeKLists(lns));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>
                (new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;
            if(n.next!=null)
                queue.offer(n.next);
        }
        return head.next;
    }
}
