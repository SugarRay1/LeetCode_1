package PB_122_MaxProfit_2;

public class Solution_122 {
    public static void main(String[] args) {
        Solution_122 sol = new Solution_122();
        int[] prices = {1, 4, 7, 5, 6, 2, 5, 1, 9, 7, 9, 7, 0, 6, 8};
        System.out.println(sol.maxProfit(prices));
    }

    //每个波峰卖出，波谷买进
    public int maxProfit(int[] prices) {
        int sum_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp_profit = prices[i] - prices[i - 1];
            if (temp_profit > 0) {
                sum_profit = sum_profit + temp_profit;
            }
        }
        return sum_profit;
    }

    //方法3：200/201出现错误
    public int maxProfit_3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            return recursive_buy_among(prices, 0, prices.length - 1);
        }
    }

    //寻找在 start和end里买的机会
    public int recursive_buy_among(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        } else if (end - start == 1) {
            return Math.max(0, prices[end] - prices[start]);
        } else {
            int min_index = get_min(prices, start, end); //确定买进点:最低谷
            if (min_index == end) {
                return recursive_buy_among(prices, start, end - 1);
            } else {
                int max_after_min = get_max(prices, min_index + 1, end);
                if ((min_index == start) && (max_after_min == end)) {
                    return continue_seeking(prices, min_index, max_after_min);
                } else if (min_index == start) {
                    return continue_seeking(prices, min_index, max_after_min) + recursive_buy_among(prices, max_after_min + 1, end);
                } else if (max_after_min == end) {
                    return recursive_buy_among(prices, start, min_index - 1) + continue_seeking(prices, min_index, max_after_min);
                } else {
                    return recursive_buy_among(prices, start, min_index - 1) + continue_seeking(prices, min_index, max_after_min) + recursive_buy_among(prices, max_after_min + 1, end);
                }
            }
        }
    }

    //start is the min, end is the largeest
    //确定在start买，end卖，但是寻找更大利润
    public int continue_seeking(int[] prices, int start, int end) {
        if (start == end) {
            return 0;
        } else if (end - start < 3) {
            return Math.max(0, prices[end] - prices[start]);
        } else {
            if (prices[end] - prices[start] <= 0) {
                return 0;
            } else {
                int min_index = get_min(prices, start + 2, end - 1);
                if (min_index == start + 1) {
                    return prices[end] - prices[start];
                } else {
                    int max_before_min = get_max(prices, start + 1, min_index - 1);
                    if (prices[max_before_min] <= prices[min_index]) {
                        return prices[end] - prices[start];
                    } else {
                        return continue_seeking(prices, start, max_before_min) + recursive_buy_among(prices, max_before_min + 1, min_index - 1) + continue_seeking(prices, min_index, end);
                    }
                }
            }
        }
    }

    public int get_min(int[] prices, int start, int end) {
        int min_index = start;
        for (int i = start; i <= end; i++) {
            if (prices[i] < prices[min_index]) {
                min_index = i;
            }
        }
        return min_index;
    }

    public int get_max(int[] prices, int start, int end) {
        int max_index = start;
        for (int j = start; j <= end; j++) {
            if (prices[j] > prices[max_index]) {
                max_index = j;
            }
        }
        return max_index;
    }


    //辅助函数：获取数组一个部分内最大和最小的索引
    public int[] get_min_and_max(int[] prices, int start, int end) {
        int[] max_and_min = new int[2];
        int max_index = start;
        int min_index = start;
        for (int i = start; i <= end; i++) {
            if (prices[i] > prices[max_index]) {
                max_index = i;
            } else if (prices[i] < prices[min_index]) {
                min_index = i;
            }
        }
        max_and_min[0] = max_index;
        max_and_min[1] = min_index;
        return max_and_min;
    }


    //方法2：超时方法，完成199/201个用例
    public int maxProfit_2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            return recursive_to_buy(prices, 0, prices.length - 1);
        }
    }

    public int recursive_to_buy(int[] prices, int start, int end) {
        if (start == end) {
            return 0;
        } else if (end - start == 1) {
            return Math.max(0, prices[end] - prices[start]);
        } else {
            if (prices[start] >= prices[start + 1]) {
                return recursive_to_buy(prices, start + 1, end);
            } else {
                return recursive_to_sell(prices, start + 1, end, start);
            }
        }
    }

    public int recursive_to_sell(int[] prices, int start, int end, int buy_index) {
        if (start == end) {
            return prices[start] - prices[buy_index];
        } else if (end - start == 1) {
            return Math.max(prices[start], prices[end]) - prices[buy_index];
        } else {
            //选择1：现在就卖
            int option_1 = prices[start] - prices[buy_index] + recursive_to_buy(prices, start + 1, end);
            //选择2:以后卖
            int larger_index = start;
            for (int i = start + 1; i <= end; i++) {
                if (prices[i] > prices[start]) {
                    larger_index = i;
                    break;
                }
            }
            if (larger_index == start) {
                return option_1;
            } else {
                int option_2 = recursive_to_sell(prices, larger_index, end, buy_index);
                return Math.max(option_1, option_2);
            }
        }
    }


}
