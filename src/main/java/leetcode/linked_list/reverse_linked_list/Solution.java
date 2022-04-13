package leetcode.linked_list.reverse_linked_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/28 20:36
 */
public class Solution {

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     * Input: head = [1,2]
     * Output: [2,1]
     *
     * Input: head = []
     * Output: []
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head)
    {
        // iterative solution
//        ListNode newHead = null;
//        while (head != null)
//        {
//            ListNode next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//
//        return newHead;

        // recursive solution
        return reverseListInt(head,null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if(head == null)
        {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next,head);
    }

}
