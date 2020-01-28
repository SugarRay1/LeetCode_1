package PB_257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> mylist = new ArrayList<>();
        recursiveBinaryTreePaths(root, "", mylist);
        return mylist;
    }

    /**
     * @param node        : 遍历节点
     * @param currentPath ： 当前路径
     * @param mylist      ： 记录所有路径
     */
    public void recursiveBinaryTreePaths(TreeNode node, String currentPath, List<String> mylist) {
        if (node != null) {
            //将当前节点的值加入路径
            if (currentPath == "") {
                currentPath = currentPath + node.val;
            } else {
                currentPath = currentPath + "->" + node.val;
            }

            //判断是否是叶子节点
            if ((node.left == null) && (node.right == null)) {
                mylist.add(currentPath);
                return;
            } else if (node.left == null) {
                recursiveBinaryTreePaths(node.right, currentPath, mylist);
            } else if (node.right == null) {
                recursiveBinaryTreePaths(node.left, currentPath, mylist);
            } else {
                //左右遍历
                recursiveBinaryTreePaths(node.left, currentPath, mylist);
                recursiveBinaryTreePaths(node.right, currentPath, mylist);
            }
        }
    }
}
