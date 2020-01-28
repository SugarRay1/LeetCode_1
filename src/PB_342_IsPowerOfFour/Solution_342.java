package PB_342_IsPowerOfFour;

public class Solution_342 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else {
            boolean flag = true;
            while (num > 1) {
                if (num % 4 != 0) {
                    flag = false;
                    break;
                } else {
                    num = num / 4;
                }
            }
            return flag;
        }
    }
}
