package PB_179_LargestNumber;

import java.util.*;

public class Solution_179 {
    public static void main(String[] args) {
        Solution_179 sol = new Solution_179();
        int[] nums = {3, 30, 34, 5, 9};
        //System.out.println(nums.toString());
        System.out.println(sol.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        //转化为List
        List<String> numsList = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(Integer.toString(nums[i]));
        }
        //排序
        Collections.sort(numsList, new Solution_179().new StringComparator());
        //转换为String返回
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numsList.size(); i++) {
            result.append(numsList.get(i));
        }
        if (result.length() == 0) {
            return "0";
        } else if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result.toString();
        }
    }

    //重写比较器
    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String combination_1 = o1 + o2;
            String combination_2 = o2 + o1;
            int n = combination_1.compareTo(combination_2);
            return -n;
        }
    }


}
