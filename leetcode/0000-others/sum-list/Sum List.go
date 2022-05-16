package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode

func addInList( head1 *ListNode ,  head2 *ListNode ) *ListNode {
	
	t1 := reverse(head1)
	t2 := reverse(head2)

	virtualNode := &ListNode{Next: nil}
	p := virtualNode

	carry := 0
	for t1 !=nil || t2 != nil {
		v := carry

		if t1 != nil {
			v += t1.Val
			t1 = t1.Next
		}

		if t2 != nil {
			v += t2.Val
			t2 = t2.Next
		}

		if v >= 10 {
			v -=10
			carry = 1
		}else {
			carry = 0
		}

		newNode := &ListNode{Val: v}
		p.Next = newNode
		p = p.Next
	}

	if carry == 1 {
		p.Next = &ListNode{Val: 1}
	}

	result := reverse(virtualNode.Next)
	return result

}

func reverse(head *ListNode) *ListNode {
	pre := (*ListNode)(nil)

	current := head
	for current != nil {
		next := current.Next
		current.Next = pre
		pre = current
		current = next
	}
	return pre
}

