package leetcode

import "algorithm/structures"



type TreeNode = structures.TreeNode


func Print( pRoot *TreeNode ) [][]int {
	// write code here

	var res = make([][]int, 0)

	if pRoot == nil {
		return res
	}

	queue := []*TreeNode{pRoot}

	var isReverse bool
	for len(queue) > 0 {
		size := len(queue)
		list := make([]int, size)
		for i := 0; i < size; i++ {
			node := queue[i]
			if !isReverse {
				list[i] = node.Val
			} else {
				list[size-i-1] = node.Val
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		queue = queue[size:]
		isReverse = !isReverse
		res = append(res, list)
	}
	return res
}