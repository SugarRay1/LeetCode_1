package PB_383_CanConstruct;

import java.util.HashMap;
import java.util.Map;

public class Solution_383 {
    public static void main(String[] args) {
        Solution_383 sol = new Solution_383();
        sol.canConstruct("aa", "ab");
    }


    //数组记录
    public boolean canConstruct2(String ransomNote, String magazine) {
        //用数组存，将magazine中的元素放入map中
        int[] words = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            words[magazine.charAt(i) - 'a']++;
        }

        //遍历ransomNote，判断
        boolean flag = true;
        for (int j = 0; j < ransomNote.length(); j++) {
            if(words[ransomNote.charAt(j)-'a']<=0){
                flag=false;
                break;
            }else{
                words[ransomNote.charAt(j)-'a']--;
            }
        }
        return flag;
    }


    //哈希表，较慢
    public boolean canConstruct(String ransomNote, String magazine) {
        //把magazine中的元素放入Map中
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!myMap.containsKey(magazine.charAt(i))) {
                myMap.put(magazine.charAt(i), 1);
            } else {
                myMap.replace(magazine.charAt(i), (myMap.get(magazine.charAt(i)) + 1));
            }
        }

        //遍历ransomNote，判断
        boolean flag = true;
        for (int j = 0; j < ransomNote.length(); j++) {
            if (myMap.containsKey(ransomNote.charAt(j))) {
                if (myMap.get(ransomNote.charAt(j)) > 0) {
                    myMap.replace(ransomNote.charAt(j), myMap.get(ransomNote.charAt(j)) - 1);
                } else {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
