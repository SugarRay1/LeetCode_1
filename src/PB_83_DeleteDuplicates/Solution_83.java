package PB_83_DeleteDuplicates;

public class Solution_83 {
    public static void main(String[] args) {
        Solution_83 sol = new Solution_83();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);

        displayNode(l1);

        sol.deleteDuplicates(l1);

        displayNode(l1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while ((current != null) && (current.next != null)) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    //测试代码，展示
    public static void displayNode(ListNode node1) {
        if (node1 == null) {
            System.out.println();
        } else if (node1.next == null) {
            System.out.println(node1.val);
        } else {
            while (node1.next != null) {
                System.out.print(node1.val + "->");
                node1 = node1.next;
            }
            System.out.print(node1.val);
            System.out.println();
        }
    }
}
