package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode

func getKthFromEnd(head *ListNode, k int) *ListNode {

	n := 0
	

	for node := head; node != nil; node = node.Next {
		n++
	}

	for i :=0; i<n-k; i++ {
		head = head.Next
	}
	return head
}