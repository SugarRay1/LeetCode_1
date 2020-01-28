package PB_234_Palindrome_LinkdList;

import java.awt.*;

public class Solution_234 {
    public boolean isPalindrome(ListNode head) {

        if ((head == null) || (head.next == null)) {
            return true;
        }

        // 1. 快慢指针，寻找中间节点
        ListNode fastTraverse = head;
        ListNode slowTraverse = head;
        while ((fastTraverse.next != null) && (fastTraverse.next.next != null)) {
            slowTraverse = slowTraverse.next;
            fastTraverse = fastTraverse.next.next;
        }
        ListNode midpoint = slowTraverse.next;

        // 2. 反转后半截
        if ((midpoint != null) && (midpoint.next != null)) {
            //前面的指针
            ListNode prev = midpoint;
            //后面的指针
            ListNode nxt = prev.next;
            prev.next = null;
            while (nxt != null) {
                midpoint = nxt;
                nxt = nxt.next;
                midpoint.next = prev;
                prev = midpoint;
            }
        }

        // 3. 比较
        boolean flag = true;
        ListNode traverse_1 = head;
        ListNode traverse_2 = midpoint;
        while (traverse_2 != null) {
            if (traverse_1.val != traverse_2.val) {
                flag = false;
                break;
            } else {
                traverse_1 = traverse_1.next;
                traverse_2 = traverse_2.next;
            }
        }
        return flag;
    }
}
