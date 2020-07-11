package JianZhi_3;

import java.util.HashSet;
import java.util.Set;

public class JZ_3 {
    public static void main(String[] args) {
        JZ_3 sol = new JZ_3();
        int[] store = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(sol.findRepeatNumber(store));
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        int target = 0;
        loop1:
        for (Integer i : nums) {
            if (!integerSet.contains(i)) {
                integerSet.add(i);
            } else {
                target = i;
                break loop1;
            }
        }
        return target;
    }
}
