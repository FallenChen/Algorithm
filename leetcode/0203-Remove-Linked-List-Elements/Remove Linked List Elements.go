package leetcode

import "algorithm/structures"


type ListNode = structures.ListNode


func removeElements(head *ListNode, val int) *ListNode {

	if head == nil {
		return head
	}

	// newHead := &structures.ListNode{Val: 0, Next: head}

	// pre := newHead
	// cur := head

	// for cur != nil {
	// 	if cur.Val == val {
	// 		pre.Next = cur.Next
	// 	}else {
	// 		pre = cur
	// 	}
	// }
	// return newHead.Next
	head.Next = removeElements(head.Next,val)
	if head.Val == val {
		return head.Next
	}else {
		return head
	}
}
