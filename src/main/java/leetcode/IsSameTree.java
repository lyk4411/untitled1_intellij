package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */

public class IsSameTree {
    public static void main(String[] args) {
        IsSameTree ist = new IsSameTree();
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



        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(1);
        TreeNode b3 = new TreeNode(2);
        TreeNode b4 = new TreeNode(2);
        TreeNode b5 = new TreeNode(3);
        TreeNode b6 = new TreeNode(3);
        TreeNode b7 = new TreeNode(4);
        TreeNode b8 = new TreeNode(4);
        TreeNode b9 = new TreeNode(5);

        b1.left  = b2;
        b1.right = b3;
        b3.left  = b4;
        b3.right = b5;
        b5.left  = b6;
        b5.right = b7;
        b7.left  = b8;
        b7.right = b9;


        System.out.println("a1 and a2 is the same?" + ist.isSameTree(a1,a2));
        System.out.println("a1 and a1 is the same?" + ist.isSameTree(a1,a1));
        System.out.println("a1 and b1 is the same?" + ist.isSameTree(a1,b1));
        System.out.println("b2 and b2 is the same?" + ist.isSameTree(b2,b2));


    }
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;

        if(p==null&&q!=null)
            return false;

        if(p!=null&&q==null)
            return false;

        if(p.val!=q.val)
            return false;
        boolean isleftsame = isSameTree(p.left,q.left);
        if(!isleftsame)
            return false;

        boolean isrightsame = isSameTree(p.right,q.right);
        if(!isrightsame)
            return false;

        return true;

    }
}
