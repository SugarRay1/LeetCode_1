package PB_105_BuildTree;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution_105 {
    public static void main(String[] args) {
        Solution_105 sol = new Solution_105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        sol.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        root = recursive_build_tree(root, preorder, 0, preorder.length, inorder, 0, inorder.length);
        return root;
    }

    public TreeNode recursive_build_tree(TreeNode root, int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start == pre_end) {
            return null;
        } else {
            //获取当前节点的值
            int value = preorder[pre_start];
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
            root.left = recursive_build_tree(root.left, preorder, pre_start + 1, pre_start + 1 + left_length, inorder, in_start, inorder_index);
            root.right = recursive_build_tree(root.right, preorder, pre_start + 1 + left_length, pre_end, inorder, inorder_index + 1, in_end);
            return root;
        }
    }


    //方法2：copy太费时间和内存？
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        TreeNode root = null;
        root = recursive_build_tree_2(root, preorder, inorder);
        return root;
    }

    public TreeNode recursive_build_tree_2(TreeNode root, int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else {
            //当前节点的值
            int value = preorder[0];
            root = new TreeNode(value);
            //获取左右子节点的前序，中序遍历
            int inorder_index = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == value) {
                    inorder_index = i;
                    break;
                }
            }
            int[] left_inorder = Arrays.copyOfRange(inorder, 0, inorder_index);
            int[] right_inorder = Arrays.copyOfRange(inorder, inorder_index + 1, inorder.length);
            int[] left_preorder = Arrays.copyOfRange(preorder, 1, 1 + left_inorder.length);
            int[] right_preorder = Arrays.copyOfRange(preorder, 1 + left_inorder.length, preorder.length);
            root.left = recursive_build_tree_2(root.left, left_preorder, left_inorder);
            root.right = recursive_build_tree_2(root.right, right_preorder, right_inorder);
            return root;
        }
    }

}
