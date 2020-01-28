package PB_12_IntToRoman;

public class Solution_12 {
    public static void main(String[] args) {
        Solution_12 sol = new Solution_12();
        System.out.println(sol.intToRoman(8));
    }


    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            num = getNext(num, str);
        }
        return str.toString();
    }

    public int getNext(int num, StringBuilder str) {
        if ((num >= 1) && (num < 4)) {
            str.append("I");
            num = num - 1;
        } else if (num == 4) {
            str.append("IV");
            num = num - 4;
        } else if ((num > 4) && (num < 9)) {
            str.append("V");
            num = num - 5;
        } else if (num == 9) {
            str.append("IX");
            num = num - 9;
        } else if ((num >= 10) && (num < 40)) {
            str.append("X");
            num = num - 10;
        } else if ((num >= 40) && (num < 50)) {
            str.append("XL");
            num = num - 40;
        } else if ((num >= 50) && (num < 90)) {
            str.append("L");
            num = num - 50;
        } else if ((num >= 90) && (num < 100)) {
            str.append("XC");
            num = num - 90;
        } else if ((num >= 100) && (num < 400)) {
            str.append("C");
            num = num - 100;
        } else if ((num >= 400) && (num < 500)) {
            str.append("CD");
            num = num - 400;
        } else if ((num >= 500) && (num < 900)) {
            str.append("D");
            num = num - 500;
        } else if ((num >= 900) && (num < 1000)) {
            str.append("CM");
            num = num - 900;
        } else if ((num >= 1000) && (num < 4000)) {
            str.append("M");
            num = num - 1000;
        }
        return num;
    }
}
