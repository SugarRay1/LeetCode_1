package PB_113_PathSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        List<Integer> temp_path = new ArrayList<Integer>();
        recursive_check_path(root, sum, temp_path, mylist);
        return mylist;
    }

    /**
     * @param root      当前节点
     * @param sum       缺少的和
     * @param temp_path 当前的已有路径
     * @param mylist    记录
     */
    public void recursive_check_path(TreeNode root, int sum, List<Integer> temp_path, List<List<Integer>> mylist) {
        if (root == null) {
            return;
        } else {
            temp_path.add(root.val);
            //等于就添加
            if ((root.val == sum) && (root.left == null) && (root.right == null)) {
                mylist.add(new ArrayList<>(temp_path));
            }
            //左右遍历
            recursive_check_path(root.left, sum - root.val, temp_path, mylist);
            recursive_check_path(root.right, sum - root.val, temp_path, mylist);
            //回溯
            temp_path.remove(temp_path.size() - 1);
        }
    }
}
