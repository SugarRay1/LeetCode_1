package PB_190_ReverseBits;

public class Solution_190 {
    public static void main(String[] args) {
        //System.out.println(2 & 1);
        Solution_190 sol = new Solution_190();
        System.out.println(sol.reverseBits(8));

    }

    public int reverseBits(int n) {
        int count = 32;
        int result = 0;
        while (count > 1) {
            result += n & 1; //
            n = n >> 1; //左移
            result = result << 1; //右移
            count--;
        }
        // 由于while循环了31次，最后一次n >> 1后，并未计算，所以在结果出，添加上右移了31次的n。
        return result += n & 1;
    }


    //方法2 一行代码
    public int reverseBits_2(int n) {
        return Integer.reverse(n);
    }

    //方法3
    // you need treat n as an unsigned value
    public int reverseBits_3(int n) {
        StringBuilder str = new StringBuilder();
        while (n != 0) {
            str.append(n % 2);
            n = n / 2;
        }
        return getIntFromString(str);
    }

    public int getIntFromString(StringBuilder str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = sum + (int) Math.pow(2, i) * (str.charAt(str.length() - 1 - i) - '0');
        }
        return sum;
    }
}
