package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func Convert(root *TreeNode) *TreeNode {
	var dfs func(cur *TreeNode)

	var pre, head *TreeNode

	dfs = func(cur *TreeNode) {
		if cur == nil {
			return
		}
		dfs(cur.Left)
		if pre != nil {
			pre.Right = cur
		} else {
			head = cur
		}
		cur.Left = pre
		pre = cur
		dfs(cur.Right)
	}
	dfs(root)
	return head
}
