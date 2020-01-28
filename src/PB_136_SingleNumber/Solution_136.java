package PB_136_SingleNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution_136 {
    public static void main(String[] args) {
        Solution_136 sol = new Solution_136();
        int[] nums = {2, 2, 1};
        System.out.println(sol.singleNumber(nums));

    }

    //异或操作
    //A ^ A = 0
    //0 ^ B = B
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }

    //遍历检查
    public int singleNumber_3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!checkHasTwo(i, nums)) {
                index = i;
                break;
            }
        }
        return nums[index];
    }

    public boolean checkHasTwo(int current, int[] nums) {
        boolean flag = false;
        for (int j = 0; j < nums.length; j++) {
            if (j == current) {
                continue;
            }
            if (nums[j] == nums[current]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //List存储
    public int singleNumber_2(int[] nums) {
        List<Integer> mylist = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            checkValues(nums[i], mylist);
        }
        return mylist.get(0);
    }

    public void checkValues(int a, List<Integer> mylist) {
        if (!mylist.contains(a)) {
            mylist.add(a);
        } else {
            mylist.remove(mylist.indexOf(a));
        }
    }
}
