package PB_35_SearchInsert;

public class Solution_35 {
    public static void main(String[] args) {
        Solution_35 sol = new Solution_35();
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(sol.searchInsert(nums, target));

    }

    //递归，二分查找
    public int searchInsert(int[] nums, int target) {
        return recursiveSearchInsert(nums, 0, nums.length - 1, target);
    }

    public int recursiveSearchInsert(int[] nums, int start, int end, int target) {
        if (nums[start] > target) {
            return start;
        } else if (nums[end] < target) {
            return end + 1;
        } else if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            if (end - 1 == start) {
                return start + 1;
            } else {
                int mid = (start + end) / 2;
                if (nums[mid] < target) {
                    return recursiveSearchInsert(nums, mid + 1, end, target);
                } else {
                    return recursiveSearchInsert(nums, start, mid, target);
                }
            }
        }
    }
}
