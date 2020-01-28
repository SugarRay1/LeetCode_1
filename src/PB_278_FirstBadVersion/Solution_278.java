/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

package PB_278_FirstBadVersion;

public class Solution_278 extends VersionControl {

    //线型方法：超时
    public int firstBadVersion2(int n) {
        int firstBad = n;

        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                firstBad = i;
                break;
            }
        }
        return firstBad;
    }

    //方法：二分查找
    public int firstBadVersion(int n) {
        return recursiveBadVersion(1, n);

    }

    public int recursiveBadVersion(int start, int end) {
        //判断框
        if (start == end) {
            return start;
        } else {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                return recursiveBadVersion(start, mid);
            } else {
                return recursiveBadVersion(mid + 1, end);
            }
        }
    }
}
