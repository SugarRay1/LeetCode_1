package PB_153_FindMin;

public class Solution_153 {
    public static void main(String[] args) {
        Solution_153 sol = new Solution_153();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(sol.findMin(nums));
    }

    public int findMin(int[] nums) {
        return recursiveFindMin(nums, 0, nums.length - 1);
    }

    public int recursiveFindMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            if (nums[start] < nums[end]) {
                return nums[start];
            } else {
                return nums[end];
            }
        } else {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                if (nums[mid] < nums[end]) {
                    return nums[start];
                } else {
                    return recursiveFindMin(nums, mid, end);
                }
            } else {
                return recursiveFindMin(nums, start, mid);
            }
        }
    }
}
