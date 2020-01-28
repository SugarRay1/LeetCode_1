package PB_206_ReverseList;

public class Solution_206 {
    //方法1：迭代一道， 反转next
    public ListNode reverseList(ListNode head) {
        //如果长度为0或1就没有必要反转了
        if ((head != null) && (head.next != null)) {
            //前面的指针
            ListNode prev = head;
            //后面的指针
            ListNode nxt = prev.next;
            prev.next = null;
            while (nxt != null) {
                head = nxt;
                nxt = nxt.next;
                head.next = prev;
                prev = head;
            }
        }
        return head;
    }

    //方法2：递归。 例子:2->1->3->4->5 变成 3->2->1->4->5
}
