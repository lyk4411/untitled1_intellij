package leetcode;

import java.util.ArrayList;

/**
 * Created by lyk on 2017/3/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        SumRoottoLeafNumbers srln = new SumRoottoLeafNumbers();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(3);
        TreeNode a7 = new TreeNode(4);
        TreeNode a8 = new TreeNode(4);
        TreeNode a9 = new TreeNode(5);

        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        a5.left = a6;
        a5.right = a7;
        a7.left = a8;
        a7.right = a9;
        System.out.println(srln.sumNumbers(a7));
    }
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if(root==null){
            return result;
        }
        ArrayList<ArrayList<TreeNode>> all = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
        l.add(root);
        dfs(root, l, all);

        for(ArrayList<TreeNode> a: all){
            StringBuilder sb = new StringBuilder();
            for(TreeNode n: a){
                sb.append(String.valueOf(n.val));
            }
            int currValue = Integer.valueOf(sb.toString());
            result = result + currValue;
        }
        return result;
    }

    public void dfs(TreeNode n, ArrayList<TreeNode> l,  ArrayList<ArrayList<TreeNode>> all){
        if(n.left==null && n.right==null){
            ArrayList<TreeNode> t = new ArrayList<TreeNode>();
            t.addAll(l);
            all.add(t);
        }
        if(n.left!=null){
            l.add(n.left);
            dfs(n.left, l, all);
            l.remove(l.size()-1);
        }
        if(n.right!=null){
            l.add(n.right);
            dfs(n.right, l, all);
            l.remove(l.size()-1);
        }
    }
}
