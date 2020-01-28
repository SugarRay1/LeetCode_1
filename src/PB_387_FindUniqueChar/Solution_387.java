package PB_387_FindUniqueChar;

public class Solution_387 {

    public int firstUniqChar_1(String s) {
        int[] records = new int[26];
        int result = -1;
        //遍历，记录
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < s.length(); j++) {
            if (records[s.charAt(j) - 'a'] == 1) {
                result = j;
                break;
            }
        }
        return result;
    }


    //方法：遍历
    public int firstUniqChar(String s) {
        int result = -1;
        int[] records = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (records[i] != -1) {
                if (!isDuplicate(s, i, records)) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    // 查看在index之后是否有相同的,标记在records
    public boolean isDuplicate(String s, int index, int[] records) {
        boolean flag = false;
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(index)) {
                records[i] = -1;
                flag = true;
            }
        }
        //
        if (flag) {
            records[index] = -1;
        }
        return flag;
    }

}
