package leetcode.stack.add_two_numbers_ii;

import java.util.Stack;

/**
 * @author cy
 * @className Solution
 * @description TODO
 * @date 2021/9/2 20:07
 */
public class Solution {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Input: l1 = [7,2,4,3], l2 = [5,6,4]
     * Output: [7,8,0,7]
     *
     * Input: l1 = [7,2,4,3], l2 = [5,6,4]
     * Output: [7,8,0,7]
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1Stack = new Stack<>();

        while (l1 != null)
        {
            l1Stack.push(l1);
            l1 = l1.next;
        }

        Stack<ListNode> l2Stack = new Stack<>();

        while (l2 != null)
        {
            l2Stack.push(l2);
            l2 = l2.next;
        }

        int carry = 0;

        ListNode dummy = null;

        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0 )
        {
            int f = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
            int s = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;

            int t = f + s + carry;

            ListNode newNode = new ListNode(t % 10);

            newNode.next = dummy;
            dummy = newNode;

            carry = t/10;

        }

        return dummy;
    }
}
