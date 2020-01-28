package PB_231_IsPowerOfTwo;

public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            boolean flag = true;
            while (n >= 2) {
                if (n % 2 == 1) {
                    flag = false;
                    break;
                }
                n = n / 2;
            }
            return flag;
        }
    }
}
