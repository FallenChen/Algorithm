package leetcode.linked_list.remove_linked_list_elements;

/**
 * @author cy
 * @className ListNode
 * @description
 * @date 2021/11/10 20:07
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {};

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}
