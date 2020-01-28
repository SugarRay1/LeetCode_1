package PB_168_ExcelConvertToTitle;

public class Solution_168 {
    public static void main(String[] args) {
        Solution_168 sol = new Solution_168();
        System.out.println(sol.convertToTitle(1));
    }

    public String convertToTitle(int n) {
//        char[] chars = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
//                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
//                'U', 'V', 'W', 'X', 'Y',};
        StringBuilder str = new StringBuilder();
        while (n != 0) {
            //str.insert(0, chars[n % 26]);
            str.insert(0, getChar_2(n % 26));
            if (n % 26 == 0) {
                n = n / 26;
                n--;
            } else {
                n = n / 26;
            }
        }
        return str.toString();
    }

    public char getChar_2(int temp) {
        char re_char = ' ';
        switch (temp) {
            case 0:
                re_char = 'Z';
                break;
            case 1:
                re_char = 'A';
                break;
            case 2:
                re_char = 'B';
                break;
            case 3:
                re_char = 'C';
                break;
            case 4:
                re_char = 'D';
                break;
            case 5:
                re_char = 'E';
                break;
            case 6:
                re_char = 'F';
                break;
            case 7:
                re_char = 'G';
                break;
            case 8:
                re_char = 'H';
                break;
            case 9:
                re_char = 'I';
                break;
            case 10:
                re_char = 'J';
                break;
            case 11:
                re_char = 'K';
                break;
            case 12:
                re_char = 'L';
                break;
            case 13:
                re_char = 'M';
                break;
            case 14:
                re_char = 'N';
                break;
            case 15:
                re_char = 'O';
                break;
            case 16:
                re_char = 'P';
                break;
            case 17:
                re_char = 'Q';
                break;
            case 18:
                re_char = 'R';
                break;
            case 19:
                re_char = 'S';
                break;
            case 20:
                re_char = 'T';
                break;
            case 21:
                re_char = 'U';
                break;
            case 22:
                re_char = 'V';
                break;
            case 23:
                re_char = 'W';
                break;
            case 24:
                re_char = 'X';
                break;
            case 25:
                re_char = 'Y';
                break;
            default:
                break;
        }
        return re_char;
    }

    public char getChar(int temp) {
        if (temp == 0) {
            return 'Z';
        } else {
            return (char) ((int) ('A') + temp - 1);
        }
    }
}
