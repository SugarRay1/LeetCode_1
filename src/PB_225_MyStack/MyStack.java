package PB_225_MyStack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List<Integer> mylist = null;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.mylist = new ArrayList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        mylist.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int returnVal = mylist.get(mylist.size() - 1);
        mylist.remove(mylist.size() - 1);
        return returnVal;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return mylist.get(mylist.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return (mylist.size() == 0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
