package PB_141_HasCycle;

public class Solution_141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else {
            boolean flag = false;
            //设置两个指针，一个跑一格，一个跑两格
            ListNode traverse_1 = head;
            ListNode traverse_2 = head.next;
            while ((traverse_1 != null) && (traverse_2 != null)) {
                //如果相等，就是环链表
                if (traverse_1.equals(traverse_2)) {
                    flag = true;
                    break;
                } else {
                    //如果traverse2.next为空，也结束
                    if (traverse_2.next == null) {
                        break;
                    } else {
                        traverse_1 = traverse_1.next;
                        traverse_2 = traverse_2.next.next;
                    }
                }
            }
            return flag;
        }
    }
}
