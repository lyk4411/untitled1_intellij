package leetcode;

import java.util.LinkedList;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode pnrpen = new PopulatingNextRightPointersinEachNode();
        TreeLinkNode tln1 = new TreeLinkNode(1);
        TreeLinkNode tln2 = new TreeLinkNode(2);
        TreeLinkNode tln3 = new TreeLinkNode(3);
        TreeLinkNode tln4 = new TreeLinkNode(4);
        TreeLinkNode tln5 = new TreeLinkNode(5);
        TreeLinkNode tln6 = new TreeLinkNode(6);
        TreeLinkNode tln7 = new TreeLinkNode(7);
        tln1.left =  tln2;
        tln1.right = tln3;
        tln2.left = tln4;
        tln2.right = tln5;
        tln3.left = tln6;
        tln3.right = tln7;
        pnrpen.connect(tln1);
        System.out.println(tln1);
    }
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;

        LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();

        if(root!=null){
            nodeQueue.offer(root);
            depthQueue.offer(1);
        }

        while(!nodeQueue.isEmpty()){
            TreeLinkNode topNode = nodeQueue.poll();
            int depth = depthQueue.poll();

            if(depthQueue.isEmpty()){
                topNode.next = null;
            }else if(depthQueue.peek()>depth){
                topNode.next = null;
            }else{
                topNode.next = nodeQueue.peek();
            }

            if(topNode.left!=null){
                nodeQueue.offer(topNode.left);
                depthQueue.offer(depth+1);
            }

            if(topNode.right!=null){
                nodeQueue.offer(topNode.right);
                depthQueue.offer(depth+1);
            }
        }
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }

//    @Override
//    public String toString() {
//        return (left!=null?left.toString():"")
//                + ":" + val + ":" +
//                (right !=null?right.toString():"");
//    }
        @Override
        public String toString() {
            return (next!=null?next.toString():"")
                    + ":" + val + ":" +
                    (left !=null?left.toString():"");
        }
}
