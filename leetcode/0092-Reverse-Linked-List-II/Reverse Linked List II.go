package leetcode

import "algorithm/structures"

// ListNode define
type ListNode = structures.ListNode

func reverseBetween(head *ListNode, left int, right int) *ListNode {

	dummyNode := &ListNode{Val: -1}

	dummyNode.Next = head

	pre := dummyNode

	for i:=0; i<left-1; i++ {
		pre = pre.Next
	}

	cur := pre.Next

	for i:=0; i< right-left; i++ {
		next := cur.Next
		cur.Next = next.Next
		next.Next = pre.Next
		pre.Next = next
	}
	return dummyNode.Next
}