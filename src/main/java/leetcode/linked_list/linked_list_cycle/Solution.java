package leetcode.linked_list.linked_list_cycle;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/2 10:12
 */
public class Solution {

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
     * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head)
    {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next!=null)
        {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)
            {
                return true;
            }
        }
        return false;
    }
}
