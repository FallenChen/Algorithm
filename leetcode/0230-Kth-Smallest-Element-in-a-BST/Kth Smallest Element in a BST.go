package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func kthSmallest(root *TreeNode, k int) int {

	// stack := []*TreeNode{}
	// for {
	// 	for root != nil {
	// 		stack = append(stack, root)
	// 		root = root.Left
	// 	}
	// 	stack, root = stack[:len(stack)-1], stack[len(stack)-1]
	// 	k--
	// 	if k == 0 {
	// 		return root.Val
	// 	}
	// 	root = root.Right
	// }

	nodeList := make([]*TreeNode, 0)

	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}

		inorder(node.Left)
		nodeList = append(nodeList, node)
		inorder(node.Right)
	}
	inorder(root)

	return nodeList[k-1].Val
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
