package PB_38_CountAndSay;

public class Solution_38 {
    public static void main(String[] args) {
        Solution_38 sol = new Solution_38();
        System.out.println(sol.countAndSay(5));
        //String str = "1211";
        //System.out.println(sol.getNext(str));
        //System.out.println(sol.checkSame(str, 3));

    }

    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        int current = 1;
        while (current < n) {
            str = getNext(str.toString());
            current++;
        }
        return str.toString();
    }

    public StringBuilder getNext(String str) {
        int current_position = 0;
        StringBuilder next_str = new StringBuilder();
        while (current_position < str.length()) {
            int next_count = checkSame(str, current_position);
            next_str = next_str.append(next_count);
            next_str = next_str.append(str.charAt(current_position));
            //next_str = next_str + next_count + str.charAt(current_position);
            current_position = current_position + next_count;
        }
        return next_str;
    }

    public int checkSame(String str, int index) {
        int count = 1;
        for (int i = index + 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(index)) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

}
