package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode


func isCompleteTree(root *TreeNode) bool {

	// 当遍历一个非空节点时，如果之前出现了空节点，那么这就不是满二叉树
	queue, found := []*TreeNode{root}, false

	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]
		if node == nil {
			found = true
		} else {
			if found {
				// 层次遍历，两个不为空的节点中出现一个nil
				return false
			}
			queue = append(queue, node.Left, node.Right)
		}
	}
	return true
}