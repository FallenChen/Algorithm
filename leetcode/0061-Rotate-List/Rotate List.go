package leetcode

import "algorithm/structures"


type ListNode = structures.ListNode

func rotateRight(head *ListNode, k int) *ListNode {

	if head == nil {
		return nil
	}

	size := 1

	slow := head
	fast := head

	for fast.Next != nil {
		size++
		fast = fast.Next
	}

	for i := size-k%size; i>1; i-- {
		slow = slow.Next
	}

	fast.Next = head
	head = slow.Next
	slow.Next = nil

	return head
}