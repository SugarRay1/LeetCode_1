package PB_74_SearchMatrix;

public class Solution_74 {
    public static void main(String[] args) {
        Solution_74 sol = new Solution_74();
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int target = 13;
//        System.out.println(sol.searchMatrix(matrix, target));
        int[][] matrix = {{}};
        System.out.println(matrix.length);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix.length == 0) || (matrix[0].length == 0)) {
            return false;
        } else {
            boolean flag = false;
            whole:
            for (int i = 0; i < matrix.length; i++) {
                if ((target >= matrix[i][0]) && (target <= matrix[i][matrix[i].length - 1])) {
                    flag = recursiveSearchInline(matrix[i], target, 0, matrix[i].length - 1);
                    break whole;
                }
            }
            return flag;
        }
    }

    //在一行中二分查找
    public boolean recursiveSearchInline(int[] inline, int target, int start, int end) {
        if (start == end) {
            return (target == inline[start]);
        } else if (end - start == 1) {
            return (target == inline[start]) || (target == inline[end]);
        } else {
            int mid = start + (end - start) / 2;
            if (target > inline[mid]) {
                return recursiveSearchInline(inline, target, mid, end);
            } else if (target < inline[mid]) {
                return recursiveSearchInline(inline, target, start, mid);
            } else {
                return true;
            }
        }
    }

}
