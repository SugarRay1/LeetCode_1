package PB_171_Excel_TitleToNumber;

public class Solution_171 {
    public static void main(String[] args) {

    }

    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + (int) Math.pow(26, i) * getInt(s.charAt(s.length() - 1 - i));
        }
        return sum;
    }

    public int getInt(char temp) {
        return temp - 'A' + 1;
    }
}
