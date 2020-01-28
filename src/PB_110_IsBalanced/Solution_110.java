package PB_110_IsBalanced;

public class Solution_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
                return false;
            } else if (!isBalanced(root.right)) {
                return false;
            } else if (!isBalanced(root.left)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
    }
}
