package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func convertBST(root *TreeNode) *TreeNode {

	if root == nil {
		return root
	}

	sum := 0
	dfs(root, &sum)
	return root
}

func dfs(root *TreeNode, sum *int) {
	if root == nil {
		return
	}

	dfs(root.Right, sum)
	// root.Val 也需要变化
	root.Val += *sum
	*sum = root.Val
	dfs(root.Left, sum)
}
