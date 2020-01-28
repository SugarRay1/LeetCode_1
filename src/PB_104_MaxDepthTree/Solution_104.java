package PB_104_MaxDepthTree;

public class Solution_104 {
    public int maxDepth(TreeNode root) {
        return recursiveMaxDepth(root);
    }

    public int recursiveMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right));
        }
    }

}
