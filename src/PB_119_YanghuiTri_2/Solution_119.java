package PB_119_YanghuiTri_2;

import PB_7_Inverse.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution_119 {

    public static void main(String[] args) {
        Solution_119 sol = new Solution_119();
        sol.getRow(5);
        System.out.println();
    }

    //优化
    public List<Integer> getRow(int rowIndex) {
        List<Integer> mylist = new ArrayList<Integer>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            mylist = changeList(mylist, i);
        }
        return mylist;
    }

    public List<Integer> changeList(List<Integer> mylist, int level) {
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
                tempList.add(mylist.get(i) + mylist.get(i - 1));
            }
            tempList.add(1);
        }
        return tempList;
    }


    //未优化方法：
    public List<Integer> getRow_2(int rowIndex) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            insertNewLevel(mylist, i);
        }
        return mylist.get(mylist.size() - 1);
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
