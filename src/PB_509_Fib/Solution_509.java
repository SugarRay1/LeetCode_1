package PB_509_Fib;

import java.util.ArrayList;
import java.util.List;

public class Solution_509 {
    public int fib(int N) {
        List<Integer> fibList = new ArrayList<Integer>();
        fibList.add(0);
        fibList.add(1);
        return recursive_fib(N, fibList);
    }

    public int recursive_fib(int N, List<Integer> fibList) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            if (fibList.size() <= N) {
                fibList.add(recursive_fib(N - 1, fibList) + recursive_fib(N - 2, fibList));
            }
            return fibList.get(N);
        }
    }
}
