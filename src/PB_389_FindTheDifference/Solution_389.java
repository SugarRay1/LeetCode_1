package PB_389_FindTheDifference;

public class Solution_389 {

    // asci码之和
    public char findTheDifference2(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count - (s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            count = count + (t.charAt(j));
        }
        return (char) (count);
    }

    //方法：记录法
    public char findTheDifference(String s, String t) {
        //数组记录
        int[] words = new int[26];
        //遍历String s
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
        }
        //遍历String t
        for (int j = 0; j < t.length(); j++) {
            words[t.charAt(j) - 'a']--;
        }
        //遍历找不同
        int index = 0;
        for (int k = 0; k < words.length; k++) {
            if (words[k] == -1) {
                index = k;
                break;
            }
        }

        return (char) ('a' + index);

    }
}
