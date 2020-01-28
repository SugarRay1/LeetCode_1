package PB_504_ConvertToBase7;

public class Solution_504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        } else {
            StringBuilder str = new StringBuilder();
            //记录符号
            boolean flag = true;
            if (num < 0) {
                flag = false;
                num = Math.abs(num);
            }
            //循环
            while (num > 0) {
                str.insert(0, num % 7);
                num = num / 7;
            }
            //符号处理
            if (!flag) {
                str.insert(0, '-');
            }
            return str.toString();
        }
    }
}
