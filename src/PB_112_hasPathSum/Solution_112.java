package PB_112_hasPathSum;

public class Solution_112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //判断是否为叶子节点
        if ((root.left == null) && (root.right == null)) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        } else if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return ((hasPathSum(root.right, sum - root.val)) || (hasPathSum(root.left, sum - root.val)));
        }
    }
}
