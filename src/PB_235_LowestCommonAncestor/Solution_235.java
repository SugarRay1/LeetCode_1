package PB_235_LowestCommonAncestor;

public class Solution_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursiveLowestCommonAncestor(root, p, q);
    }

    public TreeNode recursiveLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val == p.val) || (root.val == q.val)) {
            return root;
        } else {
            if (((p.val > root.val) && (q.val < root.val)) || ((p.val < root.val) && (q.val > root.val))) {
                return root;
            } else if ((p.val > root.val) && (q.val > root.val)) {
                return recursiveLowestCommonAncestor(root.right, p, q);
            } else {
                return recursiveLowestCommonAncestor(root.left, p, q);
            }
        }
    }


}
