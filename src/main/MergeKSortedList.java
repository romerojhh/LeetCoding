package main;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {

    }

    /*
        Use min-heap of size lists.length
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(lists.length);
        ListNode result = new ListNode();

        for (int i = 0 ; i < lists.length ; i++) {
            ListNode currNode = lists[i];
            if (currNode != null) {
                if (pq.size() == lists.length) {
                    result.val = pq.poll();

                }
                pq.add(currNode.val);
                currNode = currNode.next;
            }
        }
    }
}
