package PB_7_Inverse;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(
                1534236469));

    }

    public int reverse(int x) {
        int flag = 1; //获取符号
        if (x < 0) {
            flag = -1;
        }

        int x_abs = Math.abs(x);//复制x的绝对值
        int x_reverse = 0;//初始化
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
        int x_return = x_reverse * flag;
        return x_return;
    }
}
