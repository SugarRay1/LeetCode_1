package PB_107_LevelOrderBottom;

import java.util.ArrayList;
import java.util.List;

public class Solution_107 {
    public static void main(String[] args) {
        Solution_107 sol = new Solution_107();
        TreeNode tn1 = new TreeNode(3);
        sol.levelOrderBottom(tn1);
        System.out.println();
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        recursiveAddNodeValue(root, mylist, 1);
        return mylist;
    }

    public void recursiveAddNodeValue(TreeNode node, List<List<Integer>> mylist, int level) {
        if (node == null) {
            return;
        } else {
            //如果是这一层的第一个，就在list中新建一层
            if (level > mylist.size()) {
                List<Integer> tempList = new ArrayList<Integer>();
                mylist.add(0, tempList);
            }
            //添加自己的val值
            mylist.get(mylist.size() - level).add(0, node.val);
            //递归添加左右邻居
            recursiveAddNodeValue(node.right, mylist, level + 1);
            recursiveAddNodeValue(node.left, mylist, level + 1);
        }
    }
}
