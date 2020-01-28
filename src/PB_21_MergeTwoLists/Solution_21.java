package PB_21_MergeTwoLists;

public class Solution_21 {
    public static void main(String[] args) {
        Solution_21 sol = new Solution_21();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode returnList = sol.mergeTwoLists(l1, l2);

        displayNode(returnList);

        System.out.println();


    }

    //递归 Re
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */