package leetcode

import "algorithm/structures"


type TreeNode = structures.TreeNode

func kthSmallest(root *TreeNode, k int) int {

	stack := []*TreeNode{}
	for {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}
		stack, root = stack[:len(stack)-1], stack[len(stack)-1]
		k--
		if k == 0 {
			return root.Val
		}
		root = root.Right
	}
}

func dfs(node *TreeNode, k int, count, ans *int) {
	if node != nil {
		dfs(node.Left, k, count, ans)
		*count++
		if *count == k {
			*ans = node.Val
			return
		}
		dfs(node.Right, k, count, ans)
	}
}