package PB_102_LevelOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        recursive_add_node(root, mylist, 1);
        return mylist;
    }

    public void recursive_add_node(TreeNode root, List<List<Integer>> mylist, int level) {
        if (root == null) {
            return;
        } else {
            //判断当前行是否为空
            if (mylist.size() < level) {
                List<Integer> tempList = new ArrayList<>();
                mylist.add(tempList);
            }
            //加入元素
            mylist.get(level - 1).add(0, root.val);
            //左右子树遍历
            recursive_add_node(root.right, mylist, level + 1);
            recursive_add_node(root.left, mylist, level + 1);
        }
    }
}
