package PB_70_ClimbStairs;

public class Solution_70 {
    public static void main(String[] args) {
        Solution_70 sol = new Solution_70();
        System.out.println(sol.climbStairs(15));
    }

    //动态规划
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
            return memo[n];
        }
    }

    //暴力法
    public int climbStairs_2(int n) {
        int[] memo = new int[n + 1];
        return memoClimbStairs(n, memo);
    }

    //添加记忆数组
    public int memoClimbStairs(int n, int[] memo) {
        if (n == 0) {
            memo[n] = 1;
        } else if (n == 1) {
            memo[n] = 1;
        } else {
            memo[n] = memoClimbStairs(n - 1, memo) + memoClimbStairs(n - 2, memo);
        }
        return memo[n];
    }
}
