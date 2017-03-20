package leetcode;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree cslbst = new ConvertSortedListtoBinarySearchTree();
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
        System.out.println(cslbst.sortedListToBST(ln1));
    }

    static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head == null)
//            return null;
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode prev =null;
//        while(fast != null && fast.next != null)
//        {
//            fast = fast.next.next;
//            prev =slow;
//            slow=slow.next;
//        }
//        TreeNode root = new TreeNode(slow.val);
//        if(prev != null)
//            prev.next = null;
//        else
//            head  = null;
//
//        root.left = sortedListToBST(head);
//        root.right = sortedListToBST(slow.next);
//        return root;
//    }
}
