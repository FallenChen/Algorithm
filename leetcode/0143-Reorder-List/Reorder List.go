package leetcode

import (
	"algorithm/structures"
)

type ListNode = structures.ListNode



func reorderList(head *ListNode)  {

	if head == nil || head.Next == nil {
		return 
	}

	slow := head
	fast := head

	// find the middle
	for fast.Next !=nil && fast.Next.Next !=nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// reverse the middle-tail
	// 1->2->3->4->5 to 1->2->5->4->3
	mid := slow
	midCurrent := slow.Next
	for midCurrent.Next != nil {
		current := midCurrent.Next
		midCurrent.Next = current.Next
		current.Next = mid.Next
		mid.Next = current
	}

	// merge
	p1 := head
	p2 := mid.Next
	for p1 != mid {
		mid.Next = p2.Next
		p2.Next = p1.Next
		p1.Next = p2
		p1 = p2.Next
		p2 = mid.Next
	}

}