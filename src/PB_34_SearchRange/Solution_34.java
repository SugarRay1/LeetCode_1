package PB_34_SearchRange;

public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
        } else {
            int start_index = search_start(nums, target);
            result[0] = start_index;
            if (start_index == -1) {
                result[1] = -1;
            } else {
                int end_index = start_index;
                for (int i = start_index + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        end_index++;
                    }else{
                        break;
                    }
                }
                result[1] = end_index;
            }
        }
        return result;
    }

    public int search_start(int[] nums, int target) {
        return recursive_search_start(nums, target, 0, nums.length - 1);
    }

    public int recursive_search_start(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else if (end - start == 1) {
            if (nums[start] == target) {
                return start;
            } else {
                if (nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                return recursive_search_start(nums, target, start, mid);
            } else {
                return recursive_search_start(nums, target, mid, end);
            }
        }
    }
}
