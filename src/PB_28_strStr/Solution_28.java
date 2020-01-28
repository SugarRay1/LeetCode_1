package PB_28_strStr;

public class Solution_28 {
    public static void main(String[] args) {
        Solution_28 sol = new Solution_28();
        System.out.println(sol.strStr("hello", "ll"));

    }

    public int strStr(String haystack, String needle) {
        int index = -1;
        int subLength = needle.length();
        for (int i = 0; i < haystack.length() - subLength + 1; i++) {
            String substring = haystack.substring(i, i + subLength );
            if (substring.equals(needle)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
