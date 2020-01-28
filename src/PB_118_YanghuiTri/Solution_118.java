package PB_118_YanghuiTri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Solution_118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            insertNewLevel(mylist, i);
        }
        return mylist;
    }

    //每层的添加
    public void insertNewLevel(List<List<Integer>> mylist, int level) {
        List<Integer> tempList = new ArrayList<Integer>();
        //tempList.re
        if (level == 1) {
            tempList.add(1);
        } else if (level == 2) {
            tempList.add(1);
            tempList.add(1);
        } else {
            tempList.add(1);
            for (int i = 1; i < level - 1; i++) {
                tempList.add(mylist.get(level - 2).get(i) + mylist.get(level - 2).get(i - 1));
            }
            tempList.add(1);
        }
        mylist.add(tempList);
    }

}
