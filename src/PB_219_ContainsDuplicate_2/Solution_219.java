package PB_219_ContainsDuplicate_2;

import java.util.HashSet;
import java.util.Set;

public class Solution_219 {

    // 方法2： 用set存储，速度更快，但耗内存
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean flag = false;
        Set<Integer> mySet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                flag = true;
                break;
            } else {
                mySet.add(nums[i]);
                if (mySet.size() > k) {
                    mySet.remove(nums[i - k]);
                }
            }
        }
        return flag;
    }

    // 方法1：搜索
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        if (k >= nums.length) {
            k = nums.length - 1;
        }
        first:
        for (int i = k; i < nums.length; i++) {
            for (int j = i - k; j < i; j++) {
                if (nums[j] == nums[i]) {
                    flag = true;
                    break first;
                }
            }

        }
        return flag;
    }
}
