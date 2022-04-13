package leetcode.linked_list.remove_linked_list_elements;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/10 20:07
 */
public class Solution {

    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.
     * val == val, and return the new head.
     *
     * Input: head = [1,2,6,3,4,5,6], val = 6
     * Output: [1,2,3,4,5]
     *
     * Input: head = [], val = 1
     * Output: []
     *
     * Input: head = [7,7,7,7], val = 7
     * Output: []
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val)
    {
        if (head == null)
        {
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next: head;
    }
}
