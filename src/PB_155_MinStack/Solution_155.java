package PB_155_MinStack;

public class Solution_155 {
    public static void main(String[] args) {
        MinStack ms=new MinStack();
        ms.push(2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
    }
}
