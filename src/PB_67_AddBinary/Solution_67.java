package PB_67_AddBinary;

public class Solution_67 {
    public static void main(String[] args) {
        Solution_67 sol = new Solution_67();
        String a = "11";
        String b = "1";
        System.out.println(sol.addBinary(a, b));

    }

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();

        int position_a = a.length() - 1;
        int position_b = b.length() - 1;
        int plus = 0;
        int digit = 0;

        //a+b
        while ((position_a >= 0) || (position_b >= 0)) {
            char a_char = '0';
            char b_char = '0';
            if (position_a >= 0) {
                a_char = a.charAt(position_a);
            }
            if (position_b >= 0) {
                b_char = b.charAt(position_b);
            }

            digit = (a_char - '0') + (b_char - '0') + plus;
            //digit = Integer.parseInt(String.valueOf(a_char)) + Integer.parseInt(String.valueOf(b_char)) + plus;
            plus = digit / 2;
            digit = digit % 2;
            str.insert(0, digit);
            position_a--;
            position_b--;
        }

        //
        if (plus != 0) {
            str.insert(0, plus);
        }

        return str.toString();
    }
}
