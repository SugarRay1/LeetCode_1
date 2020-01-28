package PB_39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution_39 {
    public static void main(String[] args) {
        Solution_39 sol = new Solution_39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        List<Integer> templist = new ArrayList<Integer>();
        recursive_search_combination(candidates, target, templist, mylist, 0);
        return mylist;
    }

    public void recursive_search_combination(int[] candidates, int target, List<Integer> templist, List<List<Integer>> mylist, int start_index) {
        if (target < 0) {
            return;
        } else {
            for (int i = start_index; i < candidates.length; i++) {
                templist.add(candidates[i]);
                if (target == candidates[i]) {
                    mylist.add(new ArrayList<>(templist));
                } else {
                    recursive_search_combination(candidates, target - candidates[i], templist, mylist, i);
                }
                templist.remove(templist.size() - 1);
            }
        }
    }


}
