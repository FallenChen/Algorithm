package leetcode.two_pointers.remove_nth_node_from_end_of_list;

public class Solution {
	
	/**
	 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
	 * 
	 * Input: head = [1,2,3,4,5], n = 2
	 * Output: [1,2,3,5]
	 * 
	 * Input: head = [1], n = 1
	 * Output: []
	 * 
	 * Input: head = [1,2], n = 1
	 * Output: [1]
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) 
	{
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = dummy;

		while(n-- > 0)
		{
			fast = fast.next;
		}

		// 待删除节点的上一个节点
		ListNode pre = null;
		while(fast != null)
		{
			pre = slow;
			slow = slow.next;
			fast = fast.next;
		}

		pre.next = slow.next;
		slow.next = null;

		return dummy.next;
	}
}
