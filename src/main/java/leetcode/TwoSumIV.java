package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-4-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public static void main(String[] args) {

    }
}
