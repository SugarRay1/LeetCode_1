package PB_412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution_412 {
    public List<String> fizzBuzz(int n) {
        List<String> mylist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                mylist.add("FizzBuzz");
            } else if (i % 3 == 0) {
                mylist.add("Fizz");
            } else if (i % 5 == 0) {
                mylist.add("Buzz");
            } else {
                Integer num = new Integer(i);
                mylist.add(num.toString());
            }
        }
        return mylist;
    }
}
