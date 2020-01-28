package PB_344_ReverseString;

public class Solution_344 {
    public void reverseString(char[] s) {
        int current = 0;
        int total_length = s.length;
        while (current < total_length - 1 - current) {
            swap(s, current, total_length - 1 - current);
            current++;
        }
    }

    //交换一个自复查数组中的两位
    public void swap(char[] s, int index1, int index2) {
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }
}
