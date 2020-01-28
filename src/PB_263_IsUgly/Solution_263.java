package PB_263_IsUgly;

public class Solution_263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }
        return (num == 1);
    }
}
