package PB_202_IsHappy;

public class Solution_202 {
    public static void main(String[] args) {
        Solution_202 sol = new Solution_202();
        System.out.println(sol.isHappy(19));
        //System.out.println(sol.getNewHappy(100));

    }

    public boolean isHappy(int n) {
        while (n >= 10) {
            n = getNewHappy(n);
        }
        // 10一下只有1,7
        // 方法2：建立set看是否死循环
        if ((n == 1) || (n == 7)) {
            return true;
        } else {
            return false;
        }
    }

    public int getNewHappy(int oldHappy) {
        int newHappy = 0;
        while (oldHappy > 0) {
            newHappy = newHappy + (oldHappy % 10) * (oldHappy % 10);
            oldHappy = oldHappy / 10;
        }
        return newHappy;
    }
}
