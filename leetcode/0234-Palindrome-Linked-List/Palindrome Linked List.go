package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode

func isPalindrome(head *ListNode) bool {

	if head == nil || head.Next == nil {
		return true
	}

	res := true

	// 寻找中间节点
	p1 := head
	p2 := head

	for p2.Next != nil && p2.Next.Next != nil {
		p1 = p1.Next
		p2 = p2.Next.Next
	}

	preMiddle := p1
	preCurrent := p1.Next

	// 反转后半部分
	for preCurrent.Next != nil {
		current := preCurrent.Next
		preCurrent.Next = current.Next
		current.Next = preMiddle.Next
		preMiddle.Next = current
	}

	p1 = head
	p2 = preMiddle.Next

	// 判断是否是回文
	for p1 != preMiddle {
		if p1.Val == p2.Val {
			p1 = p1.Next
			p2 = p2.Next
		} else {
			res = false
			break
		}
	}

	if p1 == preMiddle {
		if p2 != nil && p1.Val != p2.Val {
			return false
		}
	}
	return res
}
