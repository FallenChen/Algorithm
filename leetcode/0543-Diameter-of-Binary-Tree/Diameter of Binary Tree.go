package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func diameterOfBinaryTree(root *TreeNode) int {
    
	result := 0

	checkDimaeter(root, &result)

	return result
}

func checkDimaeter(root *TreeNode, result *int) int {

	if root == nil {
		return 0
	}

	left := checkDimaeter(root.Left, result)
	right := checkDimaeter(root.Right, result)

	*result = max(*result, left+right)
	return max(left, right) + 1
}

func max(a, b int) int {
	if a > b {
		return a 
	}

	return b
}