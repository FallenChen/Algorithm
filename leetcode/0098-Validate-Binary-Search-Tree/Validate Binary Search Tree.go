package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func isValidBST(root *TreeNode) bool {
	var arr []int
	inOrder(root, &arr)

	for i := 1; i < len(arr); i++ {
		if arr[i-1] >= arr[i] {
			return false
		}
	}
	return true
}

func inOrder(root *TreeNode, arr *[]int) {
	if root == nil {
		return
	}
	inOrder(root.Left, arr)
	*arr = append(*arr, root.Val)
	inOrder(root.Right, arr)
}
