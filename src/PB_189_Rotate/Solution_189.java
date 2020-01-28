package PB_189_Rotate;

public class Solution_189 {
    public static void main(String[] args) {
        Solution_189 sol = new Solution_189();
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        sol.rotate(nums, k);

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] nums_copy = new int[nums.length];
        System.arraycopy(nums, nums.length - k, nums_copy, 0, k);
        System.arraycopy(nums, 0, nums_copy, k, nums.length - k);
        System.arraycopy(nums_copy, 0, nums, 0, nums.length);
    }
}
