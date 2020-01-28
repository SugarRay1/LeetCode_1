package PB_169_MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_169 {
    public static void main(String[] args) {
        Solution_169 sol = new Solution_169();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        sol.majorityElement(nums);

    }

    //排序，取中位值
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //方法2：哈希表
    public int majorityElement_2(int[] nums) {
        int majority = 0;
        Map<Integer, Integer> nums_dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!nums_dict.containsKey(nums[i])) {
                nums_dict.put(nums[i], 1);
            } else {
                nums_dict.put(nums[i], nums_dict.get(nums[i]) + 1);
            }
            if (nums_dict.get(nums[i]) > nums.length / 2) {
                majority = nums[i];
                break;
            }
        }
        return majority;
    }
}
