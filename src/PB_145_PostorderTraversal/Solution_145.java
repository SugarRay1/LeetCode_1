package PB_145_PostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> mylist = new ArrayList<Integer>();
        recursivePostorderTraversal(root, mylist);
        return mylist;
    }

    public void recursivePostorderTraversal(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return;
        } else {
            recursivePostorderTraversal(root.left, mylist);
            recursivePostorderTraversal(root.right, mylist);
            mylist.add(root.val);
        }
    }
}
