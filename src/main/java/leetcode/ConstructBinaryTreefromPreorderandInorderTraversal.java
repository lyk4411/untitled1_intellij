package leetcode;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,5,3,7,6,8};
        int[] inorder = new int[]{4,2,5,1,6,7,3,8};
        ConstructBinaryTreefromPreorderandInorderTraversal cbtpit = new ConstructBinaryTreefromPreorderandInorderTraversal();
        System.out.println(cbtpit.buildTree(preorder,inorder));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }

        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);

        return p;
    }
}

