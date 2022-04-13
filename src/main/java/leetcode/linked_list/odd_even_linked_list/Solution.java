package leetcode.linked_list.odd_even_linked_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/7/31 14:54
 */
public class Solution {

    /**
     * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices,
     * and return the reordered list.
     *
     * The first node is considered odd, and the second node is even, and so on.
     *
     * Note that the relative order inside both the even and odd groups should remain as it was in the input.
     *
     * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
     *
     * Input: head = [1,2,3,4,5]
     * Output: [1,3,5,2,4]
     *
     * Input: head = [2,1,3,5,6,4,7]
     * Output: [2,3,6,7,1,5,4]
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head)
    {
        if(head == null)
        {
            return null;
        }
        // odd's end is evenHead
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
