package leetcode.recursion.swap_nodes_in_pairs;

/**
 * @author cy
 * @className Solution
 * @description Given a linked list, swap every two adjacent nodes and return its head.
 *              You must solve the problem without modifying the values in the list's nodes
 *              (i.e., only nodes themselves may be changed.)
 * @date 2021/5/20 16:21
 */
public class Solution {

    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if((head == null)|| (head.next == null))
            return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
