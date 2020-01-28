package PB_203_RemoveElements;

public class Solution_203 {
    //方法1
    public ListNode removeElements(ListNode head, int val) {
        ListNode traverse = head;
        //输入表为空的情况
        if (traverse == null) {
            return head;
        }
        //只有一个元素的情况
        else if (traverse.next == null) {
            if (traverse.val == val) {
                traverse = traverse.next;
                head = head.next;
            }
            return head;
        } else {
            while (traverse.next != null) {
                //如果首位相同
                if ((traverse == head) && (traverse.val == val)) {
                    head = head.next;
                    traverse = traverse.next;
                }
                //判断删除节点元素
                else if (traverse.next.val == val) {
                    traverse.next = traverse.next.next;
                } else {
                    traverse = traverse.next;
                }
            }
            //如果首位相同
            if ((traverse == head) && (traverse.val == val)) {
                head = head.next;
                traverse = traverse.next;
            }
            return head;
        }
    }

    //方法2：逻辑清晰版
    public ListNode removeElements2(ListNode head, int val) {
        ListNode traverse = head;
        //输入表为空的情况
        if (traverse == null) {
            return head;
        }
        while (traverse.next != null) {
            //如果首位相同
            if ((traverse == head) && (traverse.val == val)) {
                head = head.next;
                traverse = traverse.next;
            }
            //判断删除节点元素
            else if (traverse.next.val == val) {
                traverse.next = traverse.next.next;
            } else {
                traverse = traverse.next;
            }
        }
        //如果首位相同
        if ((traverse == head) && (traverse.val == val)) {
            head = head.next;
            traverse = traverse.next;
        }
        return head;
    }


}
