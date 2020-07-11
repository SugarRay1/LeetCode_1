package PB_997_reverseOnlyLetters;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_997 {
    public static void main(String[] args) {
        Solution_997 sol = new Solution_997();
        System.out.println(sol.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    // 标准答案双指针，非常快
    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

    public String reverseOnlyLetters_2(String S) {
        Stack<Character> store = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Reverse
        for (Character c : S.toCharArray()) {
            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                store.push(c);
            }
        }

        // Return
        for (Character c : S.toCharArray()) {
            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                result.append(store.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // 粗糙的版本1
    public String reverseOnlyLetters_1(String S) {
        StringBuilder result = new StringBuilder(S);
        Stack<Character> store = new Stack<>();
        // Reverse
        for (int i = 0; i < result.length(); i++) {
            Character tempChar = result.charAt(i);
            if (Character.isUpperCase(tempChar) || Character.isLowerCase(tempChar)) {
                store.push(tempChar);
            }
        }
        // Return
        for (int i = 0; i < result.length(); i++) {
            if (Character.isUpperCase(result.charAt(i)) || Character.isLowerCase(result.charAt(i))) {
                if (!store.empty()) {
                    result.replace(i, i + 1, store.pop().toString());
                }
            }
        }
        return result.toString();
    }


}
