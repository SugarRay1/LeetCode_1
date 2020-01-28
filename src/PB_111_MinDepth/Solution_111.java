package PB_111_MinDepth;

public class Solution_111 {
    public int minDepth(TreeNode root) {
        return recursiveMinDepth(root);
    }

    public int recursiveMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null) {
            return 1 + recursiveMinDepth(node.right);
        } else if (node.right == null) {
            return 1 + recursiveMinDepth(node.left);
        } else {
            return 1 + Math.min(recursiveMinDepth(node.left), recursiveMinDepth(node.right));
        }
    }
}
