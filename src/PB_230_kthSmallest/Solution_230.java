package PB_230_kthSmallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_230 {
    //中序遍历
    public int count = 0;
    public int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        recursive_traverse(root, k);
        return result;
    }

    public void recursive_traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        } else {
            recursive_traverse(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
            }
            recursive_traverse(root.right, k);
        }
    }


    //方法2：遍历，取k值
    public int kthSmallest_2(TreeNode root, int k) {
        List<Integer> mylist = new ArrayList<Integer>();
        recursive_traverse_2(root, mylist);
        Collections.sort(mylist);
        return mylist.get(k - 1);
    }

    public void recursive_traverse_2(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return;
        } else {
            mylist.add(root.val);
            recursive_traverse_2(root.left, mylist);
            recursive_traverse_2(root.right, mylist);
        }
    }

}
