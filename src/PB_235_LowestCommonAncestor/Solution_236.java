package PB_235_LowestCommonAncestor;

public class Solution_236 {

    // 二叉树的公共祖先，没有用二叉搜索树的性质
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!(recursiveIsCommonAncestor(root, p, q))) {
            return null;
        } else {
            if (recursiveIsCommonAncestor(root.left, p, q)) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (recursiveIsCommonAncestor(root.right, p, q)) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }

    //查看一个节点是否是两个子节点的公共父节点
    public boolean recursiveIsCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ((recursiveIsAncestor(root, p)) && (recursiveIsAncestor(root, q)));
    }

    //查看一个节点是否是父节点
    public boolean recursiveIsAncestor(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        } else {
            if (root.val == target.val) {
                return true;
            } else {
                //寻找左子树或者右子树
                return ((recursiveIsAncestor(root.left, target)) || (recursiveIsAncestor(root.right, target)));
            }
        }
    }
}
