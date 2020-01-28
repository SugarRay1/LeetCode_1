package PB_121_MaxProfit;

import PB_7_Inverse.Solution;

public class Solution_121 {
    public static void main(String[] args) {
        Solution_121 sol = new Solution_121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(sol.maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            return recursiveMaxProfit(prices, 0, prices.length - 1);
        }
    }

    public int recursiveMaxProfit(int[] prices, int start, int end) {
        if (start == end) {
            return 0;
        } else {
            //中位数
            int mid = (start + end) / 2;
            //左右
            int max_left = recursiveMaxProfit(prices, start, mid);
            int max_right = recursiveMaxProfit(prices, mid + 1, end);
            //获取带中位数的最大利润
            int max_mid_right = prices[mid];
            int max_mid_left = prices[mid];
            //遍历
            for (int i = mid + 1; i <= end; i++) {
                if (prices[i] > max_mid_right) {
                    max_mid_right = prices[i];
                }
            }
            for (int j = mid; j >= start; j--) {
                if (prices[j] < max_mid_left) {
                    max_mid_left = prices[j];
                }
            }
            int max_mid = max_mid_right - max_mid_left;

            return maxAmongThree(max_left, max_mid, max_right);
        }
    }

    public int maxAmongThree(int a, int b, int c) {
        if ((a >= b) && (a >= c)) {
            return a;
        } else if ((b >= a) && (b >= c)) {
            return b;
        } else {
            return c;
        }
    }


}
