package PB_409_LongestPalindrome;

public class Solution_409 {
    public int longestPalindrome(String s) {
        int[] records = new int[58];
        //全记录
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'A']++;
        }


//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) {
//                records[s.charAt(i) - 'a']++;
//            } else if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) {
//                records[s.charAt(i) - 'A' + 26]++;
//            }
//        }

        //统计
        int count = 0;
        for (int j = 0; j < records.length; j++) {
            count = count + (records[j] / 2) * 2;
        }

        //中间
        if (count != s.length()) {
            count++;
        }

        return count;

    }
}
