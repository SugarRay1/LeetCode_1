package PB_172_TrailingZeros;

public class Solution_172 {

    public static void main(String[] args) {
        Solution_172 sol = new Solution_172();
        System.out.println(sol.trailingZeroes(25));
    }

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            n = n / 5;
            sum = sum + n;
        }
        return sum;
    }
}
