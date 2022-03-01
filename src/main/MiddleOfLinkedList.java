package main;

/*
    876. Middle of the Linked List

    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.
 */

public class MiddleOfLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        MiddleOfLinkedList m = new MiddleOfLinkedList();
        System.out.println(m.middleNode(a).val);
    }

    /*
       In this problem, we are going to use turtle and hare method.
       In this case, the turtle will increment by 1 node
       and the hare will increment by 2 node
       The logic behind this will be 1/2 -> 50% -> the middle point
     */
    public ListNode middleNode(ListNode head) {
        ListNode turtle = head;
        ListNode hare = head;

        while (turtle.next != null && hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }
}
