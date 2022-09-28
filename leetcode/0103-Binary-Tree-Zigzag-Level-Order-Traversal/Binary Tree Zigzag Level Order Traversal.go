package leetcode

import "algorithm/structures"

// TreeNode define
type TreeNode = structures.TreeNode

func zigzagLevelOrder(root *TreeNode) [][]int {
	var res [][]int
	dfs(root, 0, &res)
	return res
}

func dfs(root *TreeNode, level int, res *[][]int) {

	if root == nil {
		return
	}

	if len(*res) < level+1 {
		*res = append(*res, []int{})
	}

	if level%2 == 0 {
		(*res)[level] = append((*res)[level], root.Val)
	} else {
		(*res)[level] = append([]int{root.Val}, (*res)[level]...)
	}

	dfs(root.Left, level+1, res)
	dfs(root.Right, level+1, res)
}
