package PB_13_RomanToInt;

public class Solution_13 {
    public static void main(String[] args) {
        Solution_13 sol = new Solution_13();
        System.out.println(sol.romanToInt("MCMXCIV"));
        System.out.println(sol.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int romanSum = 0;
        for (int i = 0; i < s.length(); i++) {
            romanSum = romanSum + getRealIntsInt(s, i);
        }
        return romanSum;
    }

    public int getRealIntsInt(String s, int index) {
        int flag = 1;//符号
        char target = s.charAt(index);//当前位置的字符
        if ((index != s.length() - 1) && (romanCharToInt(target) < romanCharToInt(s.charAt(index + 1)))) {
            flag = -1;
        }
        return flag * romanCharToInt(target);
    }


    public int romanCharToInt(char c) {
        int romanInt = 0;
        switch (c) {
            case 'I':
                romanInt = 1;
                break;
            case 'V':
                romanInt = 5;
                break;
            case 'X':
                romanInt = 10;
                break;
            case 'L':
                romanInt = 50;
                break;
            case 'C':
                romanInt = 100;
                break;
            case 'D':
                romanInt = 500;
                break;
            case 'M':
                romanInt = 1000;
                break;
            default:
                break;
        }
        return romanInt;
    }
}
