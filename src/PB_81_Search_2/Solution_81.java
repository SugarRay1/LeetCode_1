package PB_81_Search_2;

public class Solution_81 {
    public static void main(String[] args) {
        Solution_81 sol = new Solution_81();
        int[] nums = {0, 2, 2};
        int target = 0;
        //System.out.println(sol.recursive_find_min(nums, 0, nums.length - 1));
        System.out.println(sol.search(nums, target));
    }

    //顺序好像也是100%。。。


    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        } else {
            int min_index = recursive_find_min(nums, 0, nums.length - 1);
            //顺序查找
            if (min_index == -1) {
                return sequential_search(nums, target);
            }
            //二分查找
            else {
                int max_index = nums.length - 1;
                if (min_index != 0) {
                    max_index = min_index - 1;
                }
                //越界
                if ((target > nums[max_index]) || (target < nums[min_index])) {
                    return false;
                } else {
                    if (target > nums[0]) {
                        return recursive_search(nums, target, 0, max_index);
                    } else if (target < nums[0]) {
                        return recursive_search(nums, target, min_index, nums.length - 1);
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    //顺序查找
    public boolean sequential_search(int[] nums, int target) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //二分查找
    public boolean recursive_search(int[] nums, int target, int start, int end) {
        if (end - start == 0) {
            return (target == nums[start]);
        } else if (end - start == 1) {
            return ((target == nums[start]) || (target == nums[end]));
        } else {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                return recursive_search(nums, target, mid, end);
            } else if (target < nums[mid]) {
                return recursive_search(nums, target, start, mid);
            } else {
                return true;
            }
        }
    }

    //找到最小值的下标, 如果出现都相等就顺序
    public int recursive_find_min(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            if (nums[end] >= nums[start]) {
                return start;
            } else {
                return end;
            }
        } else {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                return recursive_find_min(nums, start, mid);
            } else if (nums[start] < nums[mid]) {
                if (nums[mid] <= nums[end]) {
                    return start;
                } else {
                    return recursive_find_min(nums, mid, end);
                }
            } else {
                if (nums[end] > nums[mid]) {
                    return start;
                } else if (nums[end] == nums[mid]) {
                    //这种情况就顺序吧。。。
                    return -1;
                } else {
                    return recursive_find_min(nums, mid + 1, end);
                }
            }
        }
    }
}
