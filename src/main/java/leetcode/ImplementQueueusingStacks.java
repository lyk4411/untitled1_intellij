package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ImplementQueueusingStacks {
    Stack<Integer> temp;
    Stack<Integer> value;

    public ImplementQueueusingStacks() {
        temp = new Stack<Integer>();
        value = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        if(value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                temp.push(value.pop());
            }

            value.push(x);

            while(!temp.isEmpty()){
                value.push(temp.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public int pop() {
        return value.pop();
    }

    // Get the front element.
    public int peek() {
        return value.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}
