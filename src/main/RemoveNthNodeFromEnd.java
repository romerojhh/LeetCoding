package main;

/*
    19. Remove Nth Node From End of List

    Given the head of a linked list, remove the nth node from the end of the list and return its head.

 */

public class RemoveNthNodeFromEnd {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
        // ListNode res = r.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),2);
        // ListNode res = r.removeNthFromEnd(new ListNode(1), 1);
        ListNode res = r.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        if (head == null) {
            return null;
        }

        ListNode root = head;
        int size = 0;

        // get the size of the list
        while(root != null) {
            size++;
            root = root.next;
        }

        if (n > size) {
            return null;
        }

        root = head;
        ListNode prevNode = dummy;
        for (int i = 0 ; i < size - n ; i++) {
            prevNode = root;
            root = root.next;
        }

        prevNode.next = root.next;

        return dummy.next;
    }
}
