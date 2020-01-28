/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

package PB_374_GuessNumber;

public class Solution_374 extends GuessGame {
    public int guessNumber(int n) {
        return recursiveGuessNumber(1, n);
    }

    public int recursiveGuessNumber(int start, int end) {
        if (start == end) {
            return start;
        } else {
            int mid = start + (end - start) / 2;
            if (guess(mid) == 1) {
                return recursiveGuessNumber(mid + 1, end);
            } else if (guess(mid) == -1) {
                return recursiveGuessNumber(start, mid - 1);
            } else {
                return mid;
            }
        }
    }
}
