package leetcode.heap.merge_k_sorted_lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/12 17:25
 */
public class Solution {

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     *
     * Input: lists = []
     * Output: []
     *
     * Input: lists = [[]]
     * Output: []
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        // Brute Force
//        List<Integer> l = new ArrayList<>();
//
//        for(ListNode ln: lists)
//        {
//            while (ln != null)
//            {
//                l.add(ln.val);
//                ln = ln.next;
//            }
//        }
//
//        Collections.sort(l);
//
//        ListNode head = new ListNode(0);
//
//        ListNode h = head;
//
//        for(int i: l)
//        {
//            ListNode t = new ListNode(i);
//            h.next = t;
//            h = h.next;
//        }
//        h.next = null;
//        return head.next;

        // Compare one by one
//        int min_index = 0;
//        ListNode head = new ListNode(0);
//        ListNode h = head;
//        while (true)
//        {
//            boolean isBreak = true;
//            int min = Integer.MAX_VALUE;
//            for(int i=0; i< lists.length; i++)
//            {
//                if(lists[i] != null)
//                {
//                    if(lists[i].val < min)
//                    {
//                        min_index = i;
//                        min = lists[i].val;
//                    }
//                    isBreak = false;
//                }
//            }
//            if(isBreak)
//            {
//                break;
//            }
//            ListNode a = new ListNode(lists[min_index].val);
//            h.next = a;
//            h = h.next;
//            lists[min_index] = lists[min_index].next;
//        }
//        h.next = null;
//        return head.next;

        // priority queue
//        Comparator<ListNode> cmp;
//        cmp = new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//               return o1.val - o2.val;
//            }
//        };
//
//        Queue<ListNode> q = new PriorityQueue<>(cmp);
//        for(ListNode l : lists)
//        {
//            if(l != null)
//            {
//                q.add(l);
//            }
//        }
//
//        ListNode head = new ListNode(0);
//        ListNode point = head;
//        while (!q.isEmpty())
//        {
//            point.next = q.poll();
//            point = point.next;
//            ListNode next = point.next;
//            if(next != null)
//            {
//                q.add(next);
//            }
//        }
//       return head.next;

        // merge lists one by one
        if(lists.length == 1)
        {
            return lists[0];
        }
        if(lists.length == 0)
        {
            return null;
        }
        ListNode head = mergeTwoLists(lists[0],lists[1]);
        for(int i= 2; i< lists.length; i++)
        {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            }else
            {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1 == null)
        {
            h.next = l2;
        }
        if(l2 == null)
        {
            h.next = l1;
        }
        return ans.next;
    }
}
