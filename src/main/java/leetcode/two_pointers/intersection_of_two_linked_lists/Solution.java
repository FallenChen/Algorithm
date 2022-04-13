package leetcode.two_pointers.intersection_of_two_linked_lists;

public class Solution {
	
	// Have Intersection & Same Len
	// Have Intersection & Different Len
	// Have No Intersection & Same Len
	// Have No Intersection & Different Len
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if(null == headA || null == headB)
		{
			return null;
		}

		ListNode pA = headA;
		ListNode pB = headB;

		while(pA != pB)
		{
			pA = (null == pA) ? headB : pA.next;
			pB = (null == pB) ? headA : pB.next;
		}

		return pA;
	}
}
