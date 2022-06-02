package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode

func oddEvenList(head *ListNode) *ListNode {

	oddHead := &ListNode{Val: 0, Next: nil}
	odd := oddHead

	evenHead := &ListNode{Val: 0, Next: nil}

	even := evenHead

	counter := 1

	for head != nil {
		if counter % 2 == 1 {
			odd.Next = head
			odd = odd.Next
		}else {
			even.Next = head
			even = even.Next
		}
		head = head.Next
		counter++
	}

	even.Next = nil
	odd.Next = evenHead.Next
	return oddHead.Next
}