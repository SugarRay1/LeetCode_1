package PB_101_IsSymmetricTree;

public class Solution_101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return recursiveIsSymmetric(root.left, root.right);
        }
    }

    public boolean recursiveIsSymmetric(TreeNode left_tree, TreeNode right_tree) {
        if ((left_tree == null) && (right_tree == null)) {
            return true;
        } else if ((left_tree != null) && (right_tree == null)) {
            return false;
        } else if ((left_tree == null) && (right_tree != null)) {
            return false;
        } else {
            return ((left_tree.val == right_tree.val) && (recursiveIsSymmetric(left_tree.right, right_tree.left)) && (recursiveIsSymmetric(left_tree.left, right_tree.right)));
        }
    }
}
