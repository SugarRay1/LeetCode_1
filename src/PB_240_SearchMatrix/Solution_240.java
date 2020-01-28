package PB_240_SearchMatrix;

public class Solution_240 {
    //也可以用对角法

    //二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return false;
        } else {
            boolean flag = false;
            int end_line = get_end_line(matrix, target);
            whole:
            for (int i = 0; i < end_line; i++) {
                if ((target >= matrix[i][0]) && (target <= matrix[i][matrix[i].length - 1])) {
                    if (search_inline(matrix[i], target)) {
                        flag = true;
                        break whole;
                    }
                }
            }
            return flag;
        }
    }

    //二分查找值得搜寻的第一行，提升不大，没写
    public int get_start_line(int[][] matrix, int target) {
        return recursive_get_start_line(matrix, target, 0, matrix.length - 1);
    }

    public int recursive_get_start_line(int[][] matrix, int target, int start, int end) {
        return 0;
    }

    //二分查找值得搜寻的最后一行
    public int get_end_line(int[][] matrix, int target) {
        return recursive_get_end_line(matrix, target, 0, matrix.length - 1);

    }

    public int recursive_get_end_line(int[][] matrix, int target, int start, int end) {
        if (start == end) {
            return start;
        } else if (end - start == 1) {
            if (matrix[end][0] > target) {
                return start;
            } else {
                return end;
            }
        } else {
            int mid = start + (end - start) / 2;
            if (matrix[start][0] > target) {
                return recursive_get_end_line(matrix, target, start, mid);
            } else {
                return recursive_get_end_line(matrix, target, mid, end);
            }
        }
    }


    //查找一行内是否有
    public boolean search_inline(int[] oneline, int target) {
        return recursive_search_inline(oneline, target, 0, oneline.length - 1);
    }

    //递归二分查找
    public boolean recursive_search_inline(int[] oneline, int target, int start, int end) {
        if (start == end) {
            return (oneline[start] == target);
        } else if (end - start == 1) {
            return ((oneline[start] == target) || (oneline[end] == target));
        } else {
            int mid = start + (end - start) / 2;
            if (oneline[mid] > target) {
                return recursive_search_inline(oneline, target, start, mid);
            } else {
                return recursive_search_inline(oneline, target, mid, end);
            }
        }
    }
}
