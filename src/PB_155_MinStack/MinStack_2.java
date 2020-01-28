package PB_155_MinStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack_2 {
    private List<Integer> mylist = null;

    /**
     * initialize your data structure here.
     */
    public MinStack_2() {
        this.mylist = new ArrayList<Integer>();
    }

    public void push(int x) {
        mylist.add(0, x);
    }

    public void pop() {
        mylist.remove(0);
    }

    public int top() {
        return mylist.get(0);
    }

    public int getMin() {
        return Collections.min(mylist);
    }
}
