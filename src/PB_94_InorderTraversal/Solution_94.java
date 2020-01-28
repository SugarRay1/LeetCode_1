package PB_94_InorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> mylist = new ArrayList<Integer>();
        recursiveInorderTraversal(root, mylist);
        return mylist;
    }

    public void recursiveInorderTraversal(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return;
        } else {
            recursiveInorderTraversal(root.left, mylist);
            mylist.add(root.val);
            recursiveInorderTraversal(root.right, mylist);
        }
    }
}
