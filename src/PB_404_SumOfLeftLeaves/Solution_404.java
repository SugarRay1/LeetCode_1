/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

package PB_404_SumOfLeftLeaves;

public class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return recursiveSumOfLeftLeaves(root, false);
    }

    //左子节点加个标记
    public int recursiveSumOfLeftLeaves(TreeNode root, boolean isLeft) {
        //空节点
        if (root == null) {
            return 0;
        }
        // 是否是叶子节点
        else if ((root.left == null) && (root.right == null) && (isLeft)) {
            return root.val;
        } else {
            return recursiveSumOfLeftLeaves(root.left, true) + recursiveSumOfLeftLeaves(root.right, false);
        }
    }
}
