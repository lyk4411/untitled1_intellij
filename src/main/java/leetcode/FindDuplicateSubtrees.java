package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-4-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindDuplicateSubtrees {
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;
//    int i = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
//        System.out.println(i++);
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }


//    Map<String, Integer> count;
//    List<TreeNode> ans;
//    int i = 0;
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        count = new HashMap();
//        ans = new ArrayList();
//        collect(root);
//        return ans;
//    }
//
//    public String collect(TreeNode node) {
//        System.out.println(i++);
//        if (node == null) return "#";
//        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
//        count.put(serial, count.getOrDefault(serial, 0) + 1);
//        if (count.get(serial) == 2)
//            ans.add(node);
//        return serial;
//    }

    public static void main(String[] args) {
        FindDuplicateSubtrees fds = new FindDuplicateSubtrees();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;
        System.out.println(fds.findDuplicateSubtrees(t1));

    }
}
