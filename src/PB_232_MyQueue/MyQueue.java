package PB_232_MyQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueue {

    private List<Integer> mylist = null;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.mylist = new ArrayList<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        mylist.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int returnVal = mylist.get(0);
        mylist.remove(0);
        return returnVal;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return mylist.get(0);
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return mylist.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */