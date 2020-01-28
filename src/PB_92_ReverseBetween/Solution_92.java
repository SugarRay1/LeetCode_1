/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

package PB_92_ReverseBetween;

public class Solution_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1. 获取第m个节点
        int count = 1;
        ListNode traverse = head; // 遍历指针
        ListNode prev_last = null;
        if (m != 1) {
            while (count + 1 < m) {
                count++;
                traverse = traverse.next;
            }
            prev_last = traverse; // 第m-1个节点
            traverse = traverse.next;
            count++;
        }

        //开始反转
        ListNode rev_first = traverse;
        ListNode rev_prev = traverse;
        ListNode rev_nxt = traverse.next;
        while (count < n) {
            rev_prev = rev_nxt;
            rev_nxt = rev_nxt.next;
            rev_prev.next = traverse;
            traverse = rev_prev;
            count++;
        }

        // 表头连接
        if (m != 1) {
            prev_last.next = traverse;
            rev_first.next = rev_nxt;
        } else {
            head = traverse;
            rev_first.next = rev_nxt;
        }

        return head;
    }
}
