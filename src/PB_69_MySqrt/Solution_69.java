package PB_69_MySqrt;

public class Solution_69 {
    public static void main(String[] args) {
        Solution_69 sol = new Solution_69();
        System.out.println(sol.mySqrt(8));
    }

    public int mySqrt(int x) {
        Double sqrt = Math.sqrt(x);
        return sqrt.intValue();
    }
}
