package PB_125_IsPalindrome;

public class Solution_125 {
    public static void main(String[] args) {
        Solution_125 sol = new Solution_125();
        String s = "A man, a plan, a canal: Panama111";
        System.out.println(sol.isPalindrome(s));
    }

    //改进算法2 双指针
    public boolean isPalindrome(String s) {
        boolean flag = true;
        s = s.toLowerCase();
        int front_position = 0;
        int back_position = s.length() - 1;
        while (front_position < back_position) {
            if (!isTarget(s.charAt(front_position))) {
                front_position++;
                continue;
            }
            if (!isTarget(s.charAt(back_position))) {
                back_position--;
                continue;
            }
            if ((isTarget(s.charAt(front_position))) && (isTarget(s.charAt(back_position)))) {
                if (s.charAt(front_position) == s.charAt(back_position)) {
                    front_position++;
                    back_position--;
                } else {
                    flag = false;
                    break;
                }
            }

        }
        return flag;
    }

    public boolean isTarget(char c) {
        return (((c >= 'a') && (c <= 'z')) || ((c >= '0') && (c <= '9')));
    }


    //算法1
    public boolean isPalindrome_2(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) || ((s.charAt(i) >= '0') && (s.charAt(i) <= '9'))) {
                str.append(s.charAt(i));
            }
        }
        String str_copy = str.toString();
        return str_copy.equals(str.reverse().toString());
    }
}
