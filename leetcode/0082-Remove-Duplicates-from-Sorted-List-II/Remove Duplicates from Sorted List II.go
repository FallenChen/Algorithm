package leetcode

import "algorithm/structures"

// ListNode define
type ListNode = structures.ListNode


func deleteDuplicates(head *ListNode) *ListNode {

	sentinel := &ListNode{Next: head}

	prev := sentinel

	for head != nil {
		if head.Next != nil && head.Val == head.Next.Val {

			for head.Next != nil && head.Val == head.Next.Val {
				head = head.Next
			}
			prev.Next = head.Next
		} else {
			prev = prev.Next
		}

		head = head.Next
	}
	return sentinel.Next
}

