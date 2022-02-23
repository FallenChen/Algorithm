package reverselinkedlist

import (
	"algorithm/structures"
)


// ListNode define
type ListNode = structures.ListNode


func reverseList(head *ListNode) *ListNode {
	// var newHead *ListNode

	// change pointer
	// for head != nil {
	// 	temp := head.Next
	// 	head.Next = newHead
	// 	newHead = head
	// 	head = temp
	// }

	// return newHead

	return reverseListRecursive(head,nil)
}

func reverseListRecursive(head,newHead *ListNode) *ListNode {

	if head == nil {
		return newHead
	}

	temp := head.Next;
	head.Next = newHead
	return reverseListRecursive(temp,head)
}