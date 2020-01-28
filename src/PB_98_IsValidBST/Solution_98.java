package PB_98_IsValidBST;

import java.util.ArrayList;
import java.util.List;

public class Solution_98 {

    public boolean isValidBST(TreeNode root) {
        return recursiveIsValidBST(root, null, null);
    }

    //max:上界 min：下界
    public boolean recursiveIsValidBST(TreeNode root, Integer max, Integer min) {

        return true;

    }


    //方法2：前序遍历，改进版demo
    public boolean isValidBST_2(TreeNode root) {
        //中序遍历
        List<Integer> mylist = new ArrayList<Integer>();
        return recursiveIsValidBST_2(root, mylist);
    }

    public boolean recursiveIsValidBST_2(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return true;
        } else {
            if (!recursiveIsValidBST_2(root.left, mylist)) {
                return false;
            } else {
                boolean flag = true;
                if (mylist.size() >= 1) {
                    if (root.val <= mylist.get(mylist.size() - 1)) {
                        flag = false;
                    }
                }
                mylist.add(root.val);
                if (!flag) {
                    return false;
                } else {
                    return recursiveIsValidBST_2(root.right, mylist);
                }
            }
        }
    }


    //方法3：中序遍历在遍历数组法
    public boolean isValidBST_3(TreeNode root) {
        //中序遍历
        List<Integer> mylist = new ArrayList<Integer>();
        recursiveInorderTraversal(root, mylist);
        //检测
        boolean flag = true;
        for (int i = 0; i < mylist.size() - 1; i++) {
            if (mylist.get(i) >= mylist.get(i + 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void recursiveInorderTraversal(TreeNode root, List<Integer> mylist) {
        if (root == null) {
            return;
        } else {
            recursiveInorderTraversal(root.left, mylist);
            mylist.add(root.val);
            recursiveInorderTraversal(root.right, mylist);
        }
    }

//    public boolean recursiveIsValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        } else {
//            boolean flag = true;
//            if (root.left != null) {
//                if (root.left.val >= root.val) {
//                    flag = false;
//                }
//            }
//            if (root.right != null) {
//                if (root.right.val <= root.val) {
//                    flag = false;
//                }
//            }
//            return (flag && (recursiveIsValidBST(root.left)) && (recursiveIsValidBST(root.right)));
//        }
//    }
}
