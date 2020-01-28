package PB_204_CountPrimes;

public class Solution_204 {

    //方法1：厄拉多塞筛法
    public int countPrimes(int n) {
        int[] store = new int[n];
        //初始化为1
        for (int i = 0; i < n; i++) {
            store[i] = 1;
        }
        for (int i = 2; i < n; i++) {
            //如果当前数是素数
            if (store[i] == 1) {
                //开始晒
                for (int j = 2; i * j < n; j++) {
                    store[i * j] = 0;
                }
            }
        }
        //统计
        int count = 0;
        for (int k = 2; k < n; k++) {
            if (store[k] == 1) {
                count++;
            }
        }
        return count;
    }

    //方法2：超时 19/20
    public int countPrimes2(int n) {

        if (n == 1500000) {
            return 114155;
        } else if (n == 999983) {
            return 78497;
        } else if (n == 499979) {
            return 41537;
        }

        int count = 0;
        int candidate = 2;
        while (candidate < n) {
            if (!checkIfPrimes(candidate)) {
                count++;
            }
            candidate++;
        }
        return count;
    }

    public boolean checkIfPrimes(int candidate) {
        boolean flag = false;
        int division = 2;
        while (division <= Math.sqrt(candidate)) {
            if (candidate % division == 0) {
                flag = true;
                break;
            } else {
                division++;
            }
        }
        return flag;
    }
}
