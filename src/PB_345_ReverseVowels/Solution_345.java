package PB_345_ReverseVowels;

public class Solution_345 {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        int front = -1;
        int back = str.length();
        while (front < back) {
            front = findNewFront(str, front);
            back = findNewBack(str, back);
            if (front < back) {
                swap(str, front, back);
            }
        }
        return str.toString();
    }


    //寻找新的前置元音
    public int findNewFront(StringBuilder str, int oldFront) {
        int newFront = str.length();
        for (int i = oldFront + 1; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                newFront = i;
                break;
            }
        }
        return newFront;
    }

    //寻找新的厚纸元音
    public int findNewBack(StringBuilder str, int oldBack) {
        int newBack = -1;
        for (int j = oldBack - 1; j >= 0; j--) {
            if (isVowel(str.charAt(j))) {
                newBack = j;
                break;
            }
        }
        return newBack;
    }

    //判断字符是否是元音
    public boolean isVowel(char c) {
        return ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U'));
    }

    //交换 index1 和 index2
    public void swap(StringBuilder str, int index1, int index2) {
        char temp = str.charAt(index1);
        str.setCharAt(index1, str.charAt(index2));
        str.setCharAt(index2, temp);
    }
}
