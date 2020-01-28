package PB_18_FourSum;

import java.util.*;

public class Solution_18 {

    public static void main(String[] args) {
        Solution_18 sol = new Solution_18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        sol.fourSum(nums, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        Set<List<Integer>> mySet = new HashSet<>();
        List<Integer> templist = new ArrayList<Integer>();
        Arrays.sort(nums);
        recursive_search_next(nums, target, mySet, templist, 0);
        List<List<Integer>> result = new ArrayList<>(mySet);
        return result;
    }

    public void recursive_search_next(int[] nums, int target, Set<List<Integer>> mySet, List<Integer> templist, int start_index) {
        if ((templist.size() >= 4) || (templist.size() + nums.length - start_index < 4)) {
            return;
        } else if (((4 - templist.size()) * nums[start_index] > target) || ((4 - templist.size()) * nums[nums.length - 1] < target)) {
            return;
        } else {
            for (int i = start_index; i < nums.length; i++) {
                templist.add(nums[i]);
                if ((target == nums[i]) && (templist.size() == 4)) {
                    mySet.add(new ArrayList<>(templist));
                } else {
                    recursive_search_next(nums, target - nums[i], mySet, templist, i + 1);
                }
                templist.remove(templist.size() - 1);
            }
        }
    }
}
