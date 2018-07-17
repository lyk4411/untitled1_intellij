package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lyk on 2018-7-17.
 * Package name: leetcode
 * Porject name: untitled1
 */

public class NaryTreePostorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new LinkedList<>();

        Stack<Node> stack = new Stack<>();

        if (root == null) return ret;

        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            ret.add(0, curr.val);

            for (Node c : curr.children)
                stack.push(c);
        }

        return ret;
    }

    public static void main(String[] args) {
        NaryTreePostorderTraversal ntpt = new NaryTreePostorderTraversal();
        Node n1 = new Node(1, new ArrayList<Node>());
        Node n2 = new Node(3, new ArrayList<Node>());
        Node n3 = new Node(2, new ArrayList<Node>());
        Node n4 = new Node(4, new ArrayList<Node>());
        Node n5 = new Node(5, new ArrayList<Node>());
        Node n6 = new Node(6, new ArrayList<Node>());
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        List<Integer> al = ntpt.postorder(n1);
        System.out.println(al);
    }
}
