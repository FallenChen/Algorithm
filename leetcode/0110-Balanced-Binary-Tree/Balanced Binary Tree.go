package leetcode

import (
	"algorithm/structures"
)

type TreeNode = structures.TreeNode

func isBalanced(root *TreeNode) bool {
    
	if root == nil {
		return true
	}
	leftHeight := depth(root.Left)
	rightHeight := depth(root.Right)

	return abs(leftHeight - rightHeight) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func abs(a int) int {
	if a > 0 {
		return a
	}

	return -a
}

func depth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return max(depth(root.Left), depth(root.Right)) + 1
}


func max(a,b int) int {
	if a > b {
		return a
	}

	return b
}