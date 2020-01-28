package PB_400_FindNthDigit;

public class Solution_400 {
    public static void main(String[] args) {
        Solution_400 sol = new Solution_400();
        sol.findNthDigit(11);
    }

    public int findNthDigit(int n) {
        //找到多少位数
        int sum = 0;
        int digit = 1;
        while (sum + 9 * Math.pow(10, digit - 1) * digit < n) {
            sum = sum + 9 * (int) Math.pow(10, digit - 1) * digit;
            digit++;
        }
        //寻找在那个数字中，以及第几位
        int start_value = (int) Math.pow(10, digit - 1);
        int result_int = start_value + (n - sum - 1) / digit;
        int result_bit = (n - sum - 1) % digit;

        //获取值
        return getDigit(result_int, digit - result_bit);
    }

    public int getDigit(int target, int sequence) {
        int result = 0;
        while (sequence > 0) {
            result = target % 10;
            target = target / 10;
            sequence--;
        }
        return result;
    }
}
