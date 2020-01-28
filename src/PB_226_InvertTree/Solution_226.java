package PB_226_InvertTree;

public class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        recuriveInvertTree(root);
        return root;
    }

    public void recuriveInvertTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode prev_left = root.left;
            TreeNode prev_right = root.right;
            root.left = prev_right;
            root.right = prev_left;
            recuriveInvertTree(root.left);
            recuriveInvertTree(root.right);
        }
    }
}
