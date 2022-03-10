package leetcode

import "algorithm/structures"

// ListNode define
type ListNode = structures.ListNode

func detectCycle(head *ListNode) *ListNode {
    
	if head == nil || head.Next == nil {
		return nil
	}

	hasCycle, slow := hasCycle(head)
	if !hasCycle {
		return nil
	}

	fast := head
	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}
	return fast;

}

func hasCycle(head *ListNode) (bool, *ListNode) {
    
	fast, slow := head, head

	for slow != nil && fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if  slow == fast {
			return true, slow
		}
	}

	return false, nil
}