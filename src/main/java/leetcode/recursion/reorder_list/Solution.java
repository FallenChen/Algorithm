package leetcode.recursion.reorder_list;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/8/1 15:58
 */
public class Solution {

    /**
     * You are given the head of a singly linked-list. The list can be represented as:
     * L0 → L1 → … → Ln - 1 → Ln
     * Reorder the list to be on the following form:
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     *
     * Input: head = [1,2,3,4]
     * Output: [1,4,2,3]
     *
     * Input: head = [1,2,3,4,5]
     * Output: [1,5,2,4,3]
     *
     * @param head
     */
    public void reorderList(ListNode head)
    {
        // recursive
//        if(head == null || head.next == null || head.next.next == null)
//        {
//            return;
//        }
//
//        ListNode temp = head;
//        while (temp.next.next != null)
//        {
//            temp = temp.next;
//        }
//
//        temp.next.next = head.next;
//        head.next = temp.next;
//        temp.next = null;
//        reorderList(head.next.next);
//    }

        if(head == null || head.next == null)
        {
            return;
        }

        // [1,2,3,4,5]
        // [1,2,3,4]

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        // l1 : 1->2
        // l2 : 3->4->5

        // l1 : 1->2
        // l2 : 3->4
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step2. reverse the 2nd half
        // l1 : 1->2
        // l2 : 5->4->3

        // l1: 1->2
        // l2: 4->3
        ListNode l2 = reverse(slow);

        // step3. merge the two halves
        // l1 : 1->5->2->4->4

        // l1: 1->4->2->3
        merge(l1,l2);
    }

    private void merge(ListNode l1, ListNode l2) {

        while (l1 != null)
        {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if(n1 == null)
            {
                break;
            }

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }




}