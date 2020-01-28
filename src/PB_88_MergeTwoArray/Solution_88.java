package PB_88_MergeTwoArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_88 {
    public static void main(String[] args) {
        Solution_88 sol = new Solution_88();
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;

        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        sol.merge(nums1, m, nums2, n);

        System.out.println();

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int position = 0;
        int position_1 = 0;
        int position_2 = 0;

        while ((position_1 < m) || (position_2 < n)) {
            if ((position_2 >= n) || (n == 0)) {
                nums1[position] = nums1_copy[position_1];
                position_1++;
            } else if ((position_1 >= m) || (m == 0)) {
                nums1[position] = nums2[position_2];
                position_2++;
            } else {
                if (nums1_copy[position_1] <= nums2[position_2]) {
                    nums1[position] = nums1_copy[position_1];
                    position_1++;
                } else {
                    nums1[position] = nums2[position_2];
                    position_2++;
                }
            }
            position++;
        }


    }

}
