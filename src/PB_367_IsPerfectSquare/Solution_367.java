package PB_367_IsPerfectSquare;

public class Solution_367 {

    public static void main(String[] args) {
        Solution_367 sol = new Solution_367();
        sol.isPerfectSquare2(972196);
    }


    //方法2：二分法:
    public boolean isPerfectSquare2(int num) {
        return recursivePerfectSquare(1, num, num);
    }

    //递归二分查找
    public boolean recursivePerfectSquare(int start, int end, int num) {
        if (start == end) {
            return (start * start == num);
        } else {
            int mid = start + (end - start) / 2;
            if (mid < num / mid) {
                return recursivePerfectSquare(mid + 1, end, num);
            } else {
                return recursivePerfectSquare(start, mid, num);
            }
        }
    }


    //方法1：使用库函数
    public boolean isPerfectSquare(int num) {
        int root = (int) Math.sqrt(num);
        return (root * root == num);
    }
}
