package PB_326_IsPowerOfThree;

public class Solution_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            boolean flag = true;
            while (n > 1) {
                if (n % 3 != 0) {
                    flag = false;
                    break;
                } else {
                    n = n / 3;
                }
            }
            return flag;
        }
    }
}
