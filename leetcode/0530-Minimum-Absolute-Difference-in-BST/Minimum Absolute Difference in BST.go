package leetcode

import (
	"algorithm/structures"
	"math"
)

type TreeNode = structures.TreeNode

func getMinimumDifference(root *TreeNode) int {

	res, lastNode := math.MaxInt16, -1
	dfs(root, &res, &lastNode)
	return res
}

func dfs(root *TreeNode, res, pre *int) {
	if root == nil {
		return
	}
	// 因为有序，所以是左中右的顺序
	dfs(root.Left, res, pre)
	if *pre != -1 {
		*res = min(*res, abs(root.Val-*pre))
	}
	*pre = root.Val
	dfs(root.Right, res, pre)
}


func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func abs(a int) int {
	if a > 0 {
		return a
	}
	return -a
}