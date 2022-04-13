package leetcode.linked_list.partition_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/10/24 19:49
 */
public class Solution {

    /**
     * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     *
     * You should preserve the original relative order of the nodes in each of the two partitions.
     *
     * Input: head = [1,4,3,2,5,2], x = 3
     * Output: [1,2,2,4,3,5]
     *
     * Input: head = [2,1], x = 2
     * Output: [1,2]
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller = smallerHead, bigger = biggerHead;

        while (head != null)
        {
            if(head.val < x)
            {
                smaller = smaller.next = head;
            }
            else
            {
                bigger = bigger.next = head;
            }
            head = head.next;
        }

        smaller.next = biggerHead.next;
        // cut off anything after bigger
        bigger.next = null;
        return smallerHead.next;
    }

}
