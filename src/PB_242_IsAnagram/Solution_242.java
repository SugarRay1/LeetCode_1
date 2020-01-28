package PB_242_IsAnagram;

import java.util.Arrays;

public class Solution_242 {
    public static void main(String[] args) {
        Solution_242 sol = new Solution_242();
        System.out.println(sol.isAnagram("acebd", "ddd"));
    }

    //方法3：计数器:加个数据记录
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //方法2：改进版排序
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //字符串排序
        char[] sorted_s = s.toCharArray();
        Arrays.sort(sorted_s);
        char[] sorted_t = t.toCharArray();
        Arrays.sort(sorted_t);

        return Arrays.equals(sorted_s, sorted_t);
    }


    //方法1：原始版排序
    public boolean isAnagram(String s, String t) {
        //字符串排序
        char[] sorted_s = s.toCharArray();
        Arrays.sort(sorted_s);
        char[] sorted_t = t.toCharArray();
        Arrays.sort(sorted_t);

        if (sorted_s.length != sorted_t.length) {
            return false;
        } else {
            boolean flag = true;
            for (int i = 0; i < sorted_s.length; i++) {
                if (sorted_s[i] != sorted_t[i]) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }
}
