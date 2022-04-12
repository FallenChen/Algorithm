package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode


func deleteDuplicates(head *ListNode) *ListNode {

	// cur := head

	// if head == nil {
	// 	return nil
	// }

	// if head.Next == nil {
	// 	return head
	// }

	// for cur.Next != nil {
	// 	if cur.Next.Val == cur.Val {
	// 		cur.Next = cur.Next.Next
	// 	} else {
	// 		cur = cur.Next
	// 	}
	// }

	// return head

	if head == nil || head.Next == nil {
		return head
	}

	head.Next = deleteDuplicates(head.Next)
	if head.Next.Val == head.Val {
		return head.Next
	} else {
		return head
	}
}