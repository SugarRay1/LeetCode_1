package PB_287_FindDuplicate;

import java.util.Arrays;

public class Solution_287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Solution_287 sol = new Solution_287();
        sol.findDuplicate(nums);
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

    }

    //方法：2分法
    public int findDuplicate(int[] nums) {
        return recursive_binary_find_duplicate(nums, 1, nums.length - 1);
    }

    public int recursive_binary_find_duplicate(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                return recursive_binary_find_duplicate(nums, start, mid);
            } else {
                return recursive_binary_find_duplicate(nums, mid + 1, end);
            }
        }
    }


    //方法：排序
    public int findDuplicate_2(int[] nums) {
        int result = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }
}
