package PB_237_DeleteNode;

public class Solution_237 {
    public void deleteNode(ListNode node) {
        // 把后一个节点复制到当前节点
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }
}
