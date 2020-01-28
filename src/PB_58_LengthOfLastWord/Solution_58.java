package PB_58_LengthOfLastWord;

public class Solution_58 {
    public static void main(String[] args) {
        Solution_58 sol = new Solution_58();
        String s = "Hello World   ";
        System.out.println(sol.lengthOfLastWord(s));

    }

    public int lengthOfLastWord(String s) {
        int end_of_last_word = getLastNoSpace(s);
        if (end_of_last_word == -1) {
            return 0;
        } else if (end_of_last_word == 0) {
            return 1;
        } else {
            //获取最后一个单词的第一位
            int start_of_last_word = 0;
            for (int i = end_of_last_word - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    start_of_last_word = i;
                    break;
                }
            }
            //最前一位是否是空
            if (s.charAt(start_of_last_word) == ' ') {
                return (end_of_last_word - start_of_last_word);
            } else {
                return (end_of_last_word - start_of_last_word + 1);
            }
        }
    }

    //获取最后一个单词的末尾位
    public int getLastNoSpace(String s) {
        int new_index = s.length() - 1;
        while (new_index >= 0) {
            if (s.charAt(new_index) == ' ') {
                new_index--;
            } else {
                break;
            }
        }
        return new_index;
    }

}
