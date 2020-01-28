package PB_33_Search;

public class Solution_33 {
    public static void main(String[] args) {
        Solution_33 sol = new Solution_33();
        int[] nums = {1};
        int target = 2;
        System.out.println(sol.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else {
            int min = recursiveFindMin(nums, 0, nums.length - 1);
            if ((target >= nums[min]) && (target <= nums[nums.length - 1])) {
                return recursiveSearch(nums, target, min, nums.length - 1);
            } else {
                if (min != 0) {
                    return recursiveSearch(nums, target, 0, min - 1);
                } else {
                    return recursiveSearch(nums, target, 0, 0);
                }
            }
        }
    }

    //升序数组中查找对应值的下标
    public int recursiveSearch(int[] nums, int target, int start, int end) {
        if ((end - start <= 1) && (end - start >= 0)) {
            if (target == nums[start]) {
                return start;
            } else if (target == nums[end]) {
                return end;
            } else {
                return -1;
            }
        } else {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                return recursiveSearch(nums, target, mid, end);
            } else if (target < nums[mid]) {
                return recursiveSearch(nums, target, start, mid);
            } else {
                return mid;
            }
        }
    }

    //返回最小值的下标
    public int recursiveFindMin(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            if (nums[start] < nums[end]) {
                return start;
            } else {
                return end;
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
