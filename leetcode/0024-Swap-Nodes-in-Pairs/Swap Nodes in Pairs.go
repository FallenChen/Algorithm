package leetcode

import "algorithm/structures"

type ListNode = structures.ListNode


func swapPairs(head *ListNode) *ListNode {
	//递归的终止条件
	if head == nil || head.Next == nil {
		return head
	}
	//假设链表是 1->2->3->4
	//这句就先保存节点2
	newHead := head.Next
	//继续递归，处理节点3->4
	//当递归结束返回后，就变成了4->3
	//于是head节点就指向了4，变成1->4->3
	head.Next = swapPairs(newHead.Next)
	//将2节点指向1
	newHead.Next = head
	return newHead
}