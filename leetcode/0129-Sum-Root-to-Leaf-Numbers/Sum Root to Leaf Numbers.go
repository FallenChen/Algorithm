package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func sumNumbers(root *TreeNode) int {
    
	res := 0 

	dfs(root, 0 , &res)

	return res
}

func dfs(root *TreeNode, sum int, res *int) {
	if root == nil {
		return
	}

	sum  = sum * 10 + root.Val

	if root.Left == nil && root.Right == nil {
		*res += sum
		return
	}

	dfs(root.Left, sum, res)
	dfs(root.Right, sum, res)
}