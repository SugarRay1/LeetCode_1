package PB_258_AddDigits;

public class Solution_258 {
    public static void main(String[] args) {
        Solution_258 sol = new Solution_258();
        System.out.println(sol.addDigits(38));
    }

    public int addDigits(int num) {
        while (num >= 10) {
            num = getNewDigit(num);
        }
        return num;
    }

    public int getNewDigit(int oldNum) {
        int sum = 0;
        while (oldNum > 0) {
            sum = sum + oldNum % 10;
            oldNum = oldNum / 10;
        }
        return sum;
    }
}
