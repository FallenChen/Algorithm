package leetcode

import "algorithm/structures"

// ListNode define
type ListNode = structures.ListNode

func reverseBetween(head *ListNode, left int, right int) *ListNode {

	if head == nil {
		return head
	}

	// may be all reversed, head will lost, so we need to save it 
	newHead := &ListNode{Val :0, Next: head}
	pre := newHead

	for count :=0; pre.Next !=nil && count < left-1; count++ {
		pre = pre.Next
	}

	if pre.Next == nil {
		return head
	}

	cur := pre.Next

	// 头插法
	// 把所有节点插在pre后面
	for i :=0; i < right - left ; i++ {
		tmp := pre.Next
		pre.Next = cur.Next
		cur.Next = cur.Next.Next
		pre.Next.Next = tmp
	}
}