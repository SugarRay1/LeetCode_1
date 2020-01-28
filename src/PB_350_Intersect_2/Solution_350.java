package PB_350_Intersect_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //把nums1中的元素放入Map中
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!myMap.containsKey(nums1[i])) {
                myMap.put(nums1[i], 1);
            } else {
                myMap.replace(nums1[i], (myMap.get(nums1[i]) + 1));
            }
        }

        //遍历nums2，判断是否是重复元素
        List<Integer> mylist = new ArrayList<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (myMap.containsKey(nums2[j])) {
                if (myMap.get(nums2[j]) > 0) {
                    mylist.add(nums2[j]);
                    myMap.replace(nums2[j], (myMap.get(nums2[j]) - 1));
                }
            }
        }

        //把list中的值复制进数组中
        int[] result = new int[mylist.size()];
        for (int k = 0; k < mylist.size(); k++) {
            result[k] = mylist.get(k);
        }
        return result;

    }
}
