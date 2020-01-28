package PB_268_MissingNumber;

import java.util.Arrays;

public class Solution_268 {

    //方法2：和减去
    public int missingNumber2(int[] nums) {
        int lengthNum = nums.length;
        int missingNum = lengthNum;
        int standardSum = (lengthNum - 1) * lengthNum / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum > standardSum) {
            missingNum = missingNum - (sum - standardSum);
        }

        return missingNum;
    }

    //方法1：排序
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missingNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                missingNum = i;
                break;
            }
        }
        return missingNum;
    }
}
