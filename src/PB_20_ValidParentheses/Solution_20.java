package PB_20_ValidParentheses;

public class Solution_20 {
    public static void main(String[] args) {
        Solution_20 sol = new Solution_20();
        System.out.println(sol.isValid("(([]){})"));
    }

    public boolean isValid(String s) {
        StringBuilder s_check = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            //"(','[','{'添加，其他，如果右括号，寻找并删除对应左边括号
            if ((target == '(') || (target == '{') || (target == '[')) {
                s_check.append(target);
            } else if (target == ')') {
                int getCharIndex = s_check.lastIndexOf("(");
                if (getCharIndex == -1) {
                    return false;
                }
                if (getCharIndex == s_check.length() - 1) {
                    s_check.deleteCharAt(getCharIndex);
                }
            } else if (target == '}') {
                int getCharIndex = s_check.lastIndexOf("{");
                if (getCharIndex == -1) {
                    return false;
                }
                if (getCharIndex == s_check.length() - 1) {
                    s_check.deleteCharAt(getCharIndex);
                }
            } else if (target == ']') {
                int getCharIndex = s_check.lastIndexOf("[");
                if (getCharIndex == -1) {
                    return false;
                }
                if (getCharIndex == s_check.length() - 1) {
                    s_check.deleteCharAt(getCharIndex);
                }
            }
        }
        return (s_check.length() == 0);
    }
}
