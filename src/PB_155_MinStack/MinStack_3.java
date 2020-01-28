package PB_155_MinStack;

import java.util.Stack;

public class MinStack_3 {
    private static final int stack_max = 1000;
    private int count = 0;
    private int[] entry;

    /**
     * initialize your data structure here.
     */
    public MinStack_3() {
        entry = new int[stack_max];
    }

    public void push(int x) {
        if (count < stack_max) {
            entry[count] = x;
            count++;
        }
    }

    public void pop() {
        if (count > 0) {
            entry[count - 1] = 0;
            count--;
        }
    }

    public int top() {
        return entry[count - 1];
    }

    public int getMin() {
        int min_value = entry[0];
        for (int i = 0; i < count; i++) {
            if (entry[i] < min_value) {
                min_value = entry[i];
            }
        }
        return min_value;
    }
}
