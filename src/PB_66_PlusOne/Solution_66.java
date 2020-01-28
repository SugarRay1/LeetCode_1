package PB_66_PlusOne;

public class Solution_66 {
    public static void main(String[] args) {
        Solution_66 sol = new Solution_66();
        int[] digits = {9, 9, 9, 9};
        digits = sol.plusOne(digits);
        System.out.println();
    }

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            plus = getTenth(digits, i, plus);
            if (plus == 0) {
                break;
            }
        }
        //加一位
        if (plus == 0) {
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = plus;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
    }

    public int getTenth(int[] digits, int index, int plus) {
        int sum = digits[index] + plus;
        digits[index] = sum % 10;
        return sum / 10;
    }

}
