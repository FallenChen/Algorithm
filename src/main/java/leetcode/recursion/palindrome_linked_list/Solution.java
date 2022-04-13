package leetcode.recursion.palindrome_linked_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/6 14:06
 */
public class Solution {

    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     *
     * Input: head = [1,2,2,1]
     * Output: true
     *
     * Input: head = [1,2]
     * Output: false
     *
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head)
    {
        if(head == null)
        {
            return true;
        }

        ListNode prev = null;
        ListNode fast = head, slow = head;
        while(fast !=null && fast.next != null)
        {
            ListNode temp = prev;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            prev.next = temp;
        }
        ListNode tail = fast != null ? slow.next : slow;
        while (prev != null)
        {
            if (tail.val != prev.val)
            {
                return false;
            }
            ListNode temp = slow;
            slow = prev;
            tail = tail.next;
            prev = prev.next;
            slow.next = temp;
        }
        return true;
    }
}
