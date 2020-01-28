package PB_100_IsSameTree;

public class Solution_100 {
    public static void main(String[] args) {
        TreeNode a = null;
        TreeNode b = null;
        System.out.println((a == b));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        } else if ((p != null) && (q == null)) {
            return false;
        } else if ((p == null) && (q != null)) {
            return false;
        } else {
            return ((p.val == q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right)));
        }
    }
}
