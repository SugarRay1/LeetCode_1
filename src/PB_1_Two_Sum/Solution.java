package PB_1_Two_Sum;

public class Solution {
    public static void main(String[] args) {
        int[] myarray = {2, 7, 11, 15};
        twoSum(myarray, 9);
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] targetnums = {0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    targetnums[0] = i;
                    targetnums[1] = j;
                    break;
                }
            }
        }
        System.out.println(targetnums[0] + " " + targetnums[1]);
        return targetnums;
    }
}
