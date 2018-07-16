package leetcode;

/**
 * Created by lyk on 2018-7-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DesignLinkedList {
    final Node head = new Node(0), tail = new Node(0);
    int len;

    public DesignLinkedList() { head.next = tail;}

    public int get(int i) {
        if (i >= len) return -1;
        Node node = findPrev(i);
        return node.next.val;
    }

    public void addAtHead(int val) { addAtIndex(0, val);}

    public void addAtTail(int val) { addAtIndex(len, val);}

    public void addAtIndex(int i, int val) {
        if (i > len) return;
        Node prev = findPrev(i), next = prev.next;
        prev.next = new Node(val);
        prev.next.next = next;
        len++;
    }

    public void deleteAtIndex(int i) {
        if (i >= len) return;
        Node prev = findPrev(i);
        prev.next = prev.next.next;
        len--;
    }

    Node findPrev(int i) {
        Node node = head;
        while (i-- > 0)
            node = node.next;
        return node;
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DesignLinkedList dll = new DesignLinkedList();
        dll.addAtHead(1);
        dll.addAtTail(3);
        dll.addAtIndex(1, 2);
        System.out.println(dll.get(1));
        dll.deleteAtIndex(1);
        System.out.println(dll.get(1));
    }
}
