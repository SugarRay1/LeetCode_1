package PB_5_LongestPalindrome;

public class Solution_5 {

    public static void main(String[] args) {
        Solution_5 sol = new Solution_5();
        String str = "babad";
        System.out.println(sol.longestPalindrome(str));
    }

    // 方法：中心扩展算法
    public String longestPalindrome(String s) {
        if ((s == null) || (s.length() < 1)) {
            return "";
        } else {
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = extendPalindrome(s, i, i);
                int len2 = extendPalindrome(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }
    }

    public int extendPalindrome(String s, int left, int right) {
        while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // 方法2：暴力
    public String longestPalindrome_2(String s) {
        String str = "";
        int current_length = s.length();
        total:
        while (current_length >= 0) {
            for (int i = 0; i <= s.length() - current_length; i++) {
                String temp_str = s.substring(i, i + current_length);
                if (isPalindrome(temp_str)) {
                    str = temp_str;
                    break total;
                }
            }
            current_length--;
        }
        return str;
    }

    //判断一个字符串是否是回文
    // True:是回文; false：不是
    public boolean isPalindrome(String str) {
        boolean flag = true;
        int front = 0;
        int back = str.length() - 1;
        while (front <= back) {
            if (str.charAt(front) == str.charAt(back)) {
                front++;
                back--;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
