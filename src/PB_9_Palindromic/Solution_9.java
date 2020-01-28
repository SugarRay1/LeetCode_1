package PB_9_Palindromic;

public class Solution_9 {

    public static void main(String[] args) {
        Solution_9 sol = new Solution_9();
        System.out.println(sol.isPalindrome(-121));


    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int x_abs = Math.abs(x);//复制x的绝对值
        int x_reverse = 0;//初始化反转数
        while (x_abs > 0) {
            int single_num = x_abs % 10; //每轮获取一位
            x_abs = x_abs / 10;
            if (x_reverse > (Integer.MAX_VALUE - single_num) / 10) {
                x_reverse = 0;
                break;
            } else {
                x_reverse = x_reverse * 10 + single_num;
            }
        }
        return (x == x_reverse);

    }

}
