package leetcode

import "algorithm/structures"

// TreeNode define
type TreeNode = structures.TreeNode


func preorderTraversal(root *TreeNode) []int {
    var result []int
    preorder(root, &result)
    return result
}

func preorder(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}

	*result = append(*result, root.Val)
	preorder(root.Left, result)
	preorder(root.Right, result)
}