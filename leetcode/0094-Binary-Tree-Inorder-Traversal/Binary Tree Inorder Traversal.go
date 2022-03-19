package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func inorderTraversal(root *TreeNode) []int {
    var result []int;
    inorder(root, &result)
    return result
}

func inorder(root *TreeNode, result *[]int){
	if root != nil {
		inorder(root.Left, result)
		*result = append(*result, root.Val)
		inorder(root.Right, result)
	}
}