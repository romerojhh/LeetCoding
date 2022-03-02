package main;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    23. Merge k Sorted Lists

    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.
 */

public class MergeKSortedList {
    public static void main(String[] args) {
        MergeKSortedList m = new MergeKSortedList();
        ListNode[] list = new ListNode[3];
        list[0] = new ListNode(1,new ListNode(4,new ListNode(5)));
        list[1] = new ListNode(1,new ListNode(3, new ListNode(4)));
        list[2] = new ListNode(2,new ListNode(6));
        ListNode res = m.mergeKLists(list);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Use min-heap of size lists.length
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        // Add all the listNodes head into the min-heap
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        // Pop out the listNode head -> get the value at head and append it to result ListNode ->
        // update head = head.next -> put the head back into the min-heap
        while (!pq.isEmpty()) {
            ListNode currNode = pq.poll();
            temp.next = new ListNode(currNode.val);
            temp = temp.next;
            if (currNode.next != null) {
                pq.add(currNode.next);
            }
        }

        return dummy.next;
    }
    /*
    /*
        Use min-heap of size lists.length

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(lists.length);
        ListNode result = new ListNode();
        ListNode dummy = result;
        int nullCounter = 0;

        while (nullCounter != lists.length) {

            for (int i = 0 ; i < lists.length ; i++) {
                ListNode currNode = lists[i];

                if (currNode == null) {

                    nullCounter++;

                } else {

                    // If the min-heap is full, we are going to 'pop' the heap, returning the smallest thing in the heap

                    if (pq.size() == lists.length) {
                        // dummy.val = pq.poll();
                        dummy.next = new ListNode(pq.poll());
                        dummy = dummy.next;
                    }

                    pq.add(currNode.val);
                    lists[i] = currNode.next;
                }
            }
        }

        for (Integer i : pq) {
            dummy.next = new ListNode(i);
            dummy = dummy.next;
        }

        return result.next;
    }
    */
}
