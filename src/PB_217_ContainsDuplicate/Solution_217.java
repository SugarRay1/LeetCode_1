package PB_217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution_217 {

    //方法1：set去重
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            set.add(i);
        }
        return nums.length == set.size() ? false : true;
    }

    //方法2：set暴力解法
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Set<Integer> mySet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                flag = true;
                break;
            } else {
                mySet.add(nums[i]);
            }
        }
        return flag;
    }
}
