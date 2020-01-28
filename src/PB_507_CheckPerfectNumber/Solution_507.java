package PB_507_CheckPerfectNumber;

public class Solution_507 {
    public boolean checkPerfectNumber(int num) {
        if ((num == 1) || (num == 0)) {
            return false;
        } else {
            int sum = 0;
            int traverse = 1; //遍历数
            while (traverse <= Math.sqrt(num)) {
                //整除
                if (num % traverse == 0) {
                    sum = sum + traverse;
                    if ((num / traverse != num) && (num / traverse != traverse)) {
                        sum = sum + num / traverse;
                    }
                }
                traverse++;
            }
            return (sum == num);
        }
    }
}
