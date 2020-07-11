package PB_53_MaxSubArray;

public class Solution_53 {
    public static void main(String[] args) {
        Solution_53 sol = new Solution_53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray_2(nums));

    }

    //方法2：动态规划
    public int maxSubArray_2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            ans = getMaxAmongTwo(sum, ans);
        }
        return ans;

    }

    public int getMaxAmongTwo(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }


    //方法：分治算法
    public int maxSubArray(int[] nums) {
        return recursiveMaxSubArray(nums, 0, nums.length - 1);

    }

    public int recursiveMaxSubArray(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        //左右两边的值
        int max_left = recursiveMaxSubArray(nums, start, mid);
        int max_right = recursiveMaxSubArray(nums, mid + 1, end);
        //中间向两边
        int max_sum_left = 0;
        int max_sum_right = 0;
        int sum_left = 0;
        int sum_right = 0;
        for (int i = mid - 1; i >= 0; i--) {
            sum_left = sum_left + nums[i];
            if (sum_left > max_sum_left) {
                max_sum_left = sum_left;
            }
        }
        for (int j = mid + 1; j < nums.length; j++) {
            sum_right = sum_right + nums[j];
            if (sum_right > max_sum_right) {
                max_sum_right = sum_right;
            }
        }
        int max_mid = nums[mid] + max_sum_left + max_sum_right;
        return getMaxAmongThree(max_left, max_right, max_mid);
    }

    //得到三个数的最大值
    public int getMaxAmongThree(int a, int b, int c) {
        if ((a >= b) && (a >= c)) {
            return a;
        } else if ((b >= a) && (b >= c)) {
            return b;
        } else {
            return c;
        }
    }
}
