package PB_144_PreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> mylist = new ArrayList<Integer>();
        recursivePreorderTraversal(root, mylist);
        return mylist;
    }

    public void recursivePreorderTraversal(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return;
        } else {
            mylist.add(root.val);
            recursivePreorderTraversal(root.left, mylist);
            recursivePreorderTraversal(root.right, mylist);
        }
    }
}
