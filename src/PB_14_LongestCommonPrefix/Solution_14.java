package PB_14_LongestCommonPrefix;

public class Solution_14 {
    public static void main(String[] args) {
        Solution_14 sol = new Solution_14();
        String[] strs = {"a"};
        System.out.println(sol.longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else {
            int index = 0;
            for (int i = 0; i < strs[0].length(); i++) {
                if (!isCommon(strs, i)) {
                    index = i;
                    break;
                }
                if (i == strs[0].length() - 1) {
                    index = i + 1;
                }
            }
            return strs[0].substring(0, index);
        }
    }

    public boolean isCommon(String[] strs, int index) {
        boolean flag = true;
        for (int j = 1; j < strs.length; j++) {
            if (index >= strs[j].length()) {
                flag = false;
                break;
            }
            if (strs[j].charAt(index) != strs[0].charAt(index)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
