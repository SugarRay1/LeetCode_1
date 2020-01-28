
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

package PB_437_PathSum;

public class Solution_437{
    public int pathSum(TreeNode root, int sum) {
        return recursivePathSum(root, sum, 0);
    }

    public int recursivePathSum(TreeNode root, int sum, int alreadySum) {
        if (root == null) {
            return 0;
        } else {
            int path = 0;
            if (alreadySum + root.val == sum) {
                path++;
            }
            if (root.left != null) {
                path = path + recursivePathSum(root.left, sum, alreadySum + root.val) + recursivePathSum(root.left, sum, root.val);
            }
            if (root.right != null) {
                path = path + recursivePathSum(root.right, sum, alreadySum + root.val) + recursivePathSum(root.right, sum, root.val);
            }
            return path;
        }
    }

}
