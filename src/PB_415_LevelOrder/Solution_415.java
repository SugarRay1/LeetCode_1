package PB_415_LevelOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution_415 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> mylist = new ArrayList<>();
        recursiveLovelOrder(root, 0, mylist);
        return mylist;
    }

    public void recursiveLovelOrder(Node root, int level, List<List<Integer>> mylist) {
        if (root == null) {
            return;
        } else {
            //改层第一个
            if (level + 1 > mylist.size()) {
                List<Integer> oneline=new ArrayList<Integer>();
                mylist.add(oneline);
            }
            //将值加入
            mylist.get(level).add(root.val);
            //遍历儿子
            for (int i = 0; i < root.children.size(); i++) {
                recursiveLovelOrder(root.children.get(i), level + 1, mylist);
            }
        }
    }
}
