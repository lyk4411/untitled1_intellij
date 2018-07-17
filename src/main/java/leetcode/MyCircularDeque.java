package leetcode;

/**
 * Created by lyk on 2018-7-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MyCircularDeque {
    int[] arr;
    int f = 0, e = 0, k, num = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        this.k = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (!isEmpty())
            f = f == 0 ? k - 1 : f - 1;
        arr[f] = value;
        num++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (!isEmpty())
            e = (e + 1) % k;
        arr[e] = value;
        num++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (f != e) f = (f + 1) % k;
        num--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (f != e) e = e == 0 ? k - 1 : e - 1;
        num--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[f];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[e];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return num == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return num == k;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);			// return true
        circularDeque.insertLast(2);			// return true
        circularDeque.insertFront(3);			// return true
        circularDeque.insertFront(4);			// return false, the queue is full
        System.out.println(circularDeque.getRear());  			// return 32
        circularDeque.isFull();				// return true
        circularDeque.deleteLast();			// return true
        circularDeque.insertFront(4);			// return true
        System.out.println(circularDeque.getFront());			// return 4
    }
}
