package leetcode

import (
	"algorithm/structures"
)

// ListNode define
type ListNode = structures.ListNode

func reverseKGroup(head *ListNode, k int) *ListNode {
    if k == 1 {
	return head
    }
    node := head

    for i := 0; i < k; i++ {
	if node == nil {
	    return head
	}
	node = node.Next
    }

    newHead := reverse(head,node)
    head.Next = reverseKGroup(node,k)
    return newHead
}

func reverse(first *ListNode, last *ListNode) *ListNode {
	// must have to ,can not change last
	prev := last

	for first != last {
		temp := first.Next
		first.Next = prev
		prev = first
		first = temp
	}
	return prev
}