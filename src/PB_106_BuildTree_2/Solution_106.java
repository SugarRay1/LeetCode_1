package PB_106_BuildTree_2;

public class Solution_106 {
    public static void main(String[] args) {
        Solution_106 sol = new Solution_106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        sol.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        root = recursive_build_tree(root, inorder, 0, inorder.length, postorder, 0, postorder.length);
        return root;
    }

    public TreeNode recursive_build_tree(TreeNode root, int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
        if (in_start == in_end) {
            return null;
        } else {
            //获取当前节点的值
            int value = postorder[post_end - 1];
            root = new TreeNode(value);
            //获取左右子节点的前序，中序遍历
            int inorder_index = -1;
            for (int i = in_start; i < in_end; i++) {
                if (inorder[i] == value) {
                    inorder_index = i;
                    break;
                }
            }
            int left_length = inorder_index - in_start; // 左子树长度
            root.left = recursive_build_tree(root.left, inorder, in_start, inorder_index, postorder, post_start, post_start + left_length);
            root.right = recursive_build_tree(root.right, inorder, inorder_index + 1, in_end, postorder, post_start + left_length, post_end - 1);
            return root;
        }
    }
}
