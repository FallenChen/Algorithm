package leetcode.linked_list.remove_duplicates_from_sorted_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/29 20:22
 */
public class Solution {

    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     *
     * Input: head = [1,1,2]
     * Output: [1,2]
     *
     * Input: head = [1,1,2,3,3]
     * Output: [1,2,3]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head)
    {
//        ListNode current = head;
//        while (current != null && current.next != null)
//        {
//            if(current.next.val == current.val)
//            {
//                current.next = current.next.next;
//            }
//            else
//            {
//                current = current.next;
//            }
//        }
//        return head;

        // recursive
        if(head == null || head.next == null)
        {
            return head;
        }

        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
