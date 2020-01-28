package PB_349_Intersection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //把nums1中的元素放入集合
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        //遍历nums2，判断是否是重复元素
        List<Integer> mylist = new ArrayList<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                set.remove(nums2[j]);
                mylist.add(nums2[j]);
            }
        }

        //把list中的值复制进数组中
        int[] result=new int[mylist.size()];
        for (int k = 0; k <mylist.size() ; k++) {
            result[k]=mylist.get(k);
        }
        return result;
    }
}
