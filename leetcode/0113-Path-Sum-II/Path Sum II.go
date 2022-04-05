package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func pathSum(root *TreeNode, targetSum int) [][]int {
    
	var result [][]int

	result = dfs(root, targetSum, result, []int{})

	return result
}

func dfs(node *TreeNode, sum int, result [][]int, stack []int) [][]int {
	if node == nil {
		return result
	}

	sum -= node.Val

	stack = append(stack, node.Val)

	if sum == 0 && node.Left == nil && node.Right == nil {
		result = append(result, append([]int{}, stack...))
		stack = stack[:len(stack) - 1]
	}
	result = dfs(node.Left,sum, result, stack)
	result = dfs(node.Right, sum, result, stack)

	return result
}