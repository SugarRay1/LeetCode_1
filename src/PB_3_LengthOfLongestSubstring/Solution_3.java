package PB_3_LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 sol = new Solution_3();
        String str = "abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(str));
    }

    // 方法：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> mySet = new HashSet<Character>();
        int i = 0;
        int j = 0;
        while ((i < s.length()) && (j < s.length())) {
            if (!mySet.contains(s.charAt(j))) {
                mySet.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                mySet.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    // 方法2：超时的暴力算法
    public int lengthOfLongestSubstring_2(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            int longest_length = 1;
            int check_length = s.length();
            while (check_length >= 2) {
                if (isContains(s, check_length)) {
                    longest_length = check_length;
                    break;
                } else {
                    check_length--;
                }
            }
            return longest_length;
        }
    }

    //检查字符串中是否包含长度为 len 的 不重复子字符串
    // true:包含 false:不包含
    public boolean isContains(String s, int length) {
        boolean flag = false;
        for (int i = 0; i <= s.length() - length; i++) {
            String tempStr = s.substring(i, i + length);
            //检测，如果出现不重复的，break
            if (!isDuplicate(tempStr)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //检查一个字符串是否重复
    //true：重复, false:不重复
    public boolean isDuplicate(String substr) {
        boolean flag = false;
        Set<Character> mySet = new HashSet<Character>();
        for (int i = 0; i < substr.length(); i++) {
            char tempChar = substr.charAt(i);
            if (mySet.contains(tempChar)) {
                flag = true;
                break;
            } else {
                mySet.add(tempChar);
            }
        }
        return flag;
    }


}
