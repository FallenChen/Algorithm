package leetcode.recursion.reverse_nodes_in_k_group;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/10 20:20
 */
public class Solution {

    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     *
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     *
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     *
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     *
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     *
     * Input: head = [1,2,3,4,5], k = 1
     * Output: [1,2,3,4,5]
     *
     * Input: head = [1], k = 1
     * Output: [1]
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // find the k+1 node
        while (curr != null && count != k)
        {
            curr = curr.next;
            count++;
        }

        if(count == k) // if k+1 node is found
        {
            // reverse list with k+1 node as head
            curr = reverseKGroup(curr,k);

            // head - head-pointer to direct part
            // curr - head-pointer to reversed part
            while (count-- > 0) // reverse current k-group
            {
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = curr;
                // move head of reversed part to a new node
                curr = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
