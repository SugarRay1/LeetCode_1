package PB_191_HammingWeight;

public class Solution_191 {
    public static void main(String[] args) {
        Solution_191 sol = new Solution_191();
        System.out.println(sol.hammingWeight(3));

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        int count = 32;
        while (count > 1) {
            if ((n & 1) == 1) {
                num++;
            }
            n = n >> 1;
            count--;
        }
        return num;
    }
}
