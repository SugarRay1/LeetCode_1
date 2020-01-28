package PB_26_RemoveDuplicates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution_26 {
    public static void main(String[] args) {
        Solution_26 sol = new Solution_26();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //System.out.println(sol.checkDuplicates(nums, 5));
//        sol.deleteDuplicates(nums, 1);
//        displayNums(nums);
        System.out.println(sol.removeDuplicates(nums));
        displayNums(nums);


    }

    public int removeDuplicates(int[] nums) {
        int current_position = 0;
        int current_length = nums.length;
        while (current_position <= current_length - 1) {
            if (checkDuplicates(nums, current_position)) {
                current_length--;
                deleteDuplicates(nums, current_position);
            } else {
                current_position++;
            }
        }
        return current_position;
    }

    //在数组中删除nums的index位置
    public void deleteDuplicates(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    //检验数组nums中，在index之前，是否有与nums[index]重复的元素
    public boolean checkDuplicates(int[] nums, int index) {
        boolean flag = false;
        for (int i = 0; i < index; i++) {
            if (nums[i] == nums[index]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void displayNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    //参考答案：双指针法
    public int removeDuplicates_2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }



}
