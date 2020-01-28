package PB_303_NumArray;

public class NumArray {

    private int[] myNums;
    private int[] sumArray;

    public NumArray(int[] nums) {
        this.myNums = nums;
        this.sumArray = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            sumArray[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumArray[j] - sumArray[i] + myNums[i];
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
