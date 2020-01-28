package PB_198_Rob;

public class Solution_198 {
    public static void main(String[] args) {
        Solution_198 sol = new Solution_198();
        //int[] nums = {226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124};
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(sol.rob(nums));

    }

    //动态规划
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            int[] max_money = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    max_money[0] = nums[0];
                } else if (i == 1) {
                    max_money[1] = Math.max(nums[0], nums[1]);
                } else {
                    max_money[i] = Math.max(max_money[i - 1], nums[i] + max_money[i - 2]);
                }
            }
            return max_money[max_money.length - 1];
        }
    }

    //超时算法
    public int rob_2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            return recursive_rob(nums, nums.length - 1);
        }
    }

    public int recursive_rob(int[] nums, int number) {
        if (number == 0) {
            return nums[number];
        } else if (number == 1) {
            return Math.max(nums[number - 1], nums[number]);
        } else {
            int option_1 = recursive_rob(nums, number - 1);
            int option_2 = nums[number] + recursive_rob(nums, number - 2);
            return Math.max(option_1, option_2);
        }
    }

    //超时算法
    public int rob_3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            return recursive_rob(nums, 0, nums.length - 1);
        }
    }

    public int recursive_rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        } else if (end - start == 2) {
            return Math.max(nums[start] + nums[start + 2], nums[start + 1]);
        } else {
            int option_1 = nums[start] + recursive_rob(nums, start + 2, end);
            int option_2 = nums[start + 1] + recursive_rob(nums, start + 3, end);
            return Math.max(option_1, option_2);
        }
    }

}
