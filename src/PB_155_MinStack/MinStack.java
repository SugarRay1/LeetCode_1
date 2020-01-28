package PB_155_MinStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class MinStack {

    //标答：辅助栈
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */