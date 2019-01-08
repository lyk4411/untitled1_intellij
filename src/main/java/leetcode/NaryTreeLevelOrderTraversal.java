package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2019-1-8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> llist = new ArrayList<>();
        if (root == null){
            return llist;
        }
        ArrayDeque<Node> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++ i){
                Node tmp = que.poll();
                list.add(tmp.val);
                for (Node node : tmp.children){
                    if (node != null){
                        que.offer(node);
                    }
                }
            }
            llist.add(list);
        }
        return llist;
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal ntot = new NaryTreeLevelOrderTraversal();
        List<Node> ch1 = new ArrayList<>();
        List<Node> ch2 = new ArrayList<>();
        List<Node> ch3 = new ArrayList<>();
        List<Node> ch4 = new ArrayList<>();
        List<Node> ch5 = new ArrayList<>();
        List<Node> ch6 = new ArrayList<>();
        Node n1 = new Node(1, ch1);
        Node n2 = new Node(2, ch2);
        Node n3 = new Node(3, ch3);
        Node n4 = new Node(4, ch4);
        Node n5 = new Node(5, ch5);
        Node n6 = new Node(6, ch6);
        ch1.add(n2);
        ch1.add(n3);
        ch1.add(n4);
        ch2.add(n5);
        ch2.add(n6);
        System.out.println(ntot.levelOrder(n1));
    }
}
