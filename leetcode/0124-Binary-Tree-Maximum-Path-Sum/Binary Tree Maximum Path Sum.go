package leetcode

import (
	"algorithm/structures"
	"math"
)

type TreeNode = structures.TreeNode

func maxPathSum(root *TreeNode) int {

	// if root == nil {
	// 	return 0
	// }

	// max := math.MinInt32
	// getPathSum(root, &max)
	// return max

	maxSum := math.MinInt32

	var dfs func(root *TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		left := dfs(root.Left)
		right := dfs(root.Right)

		innerMaxSum := left + root.Val + right
		maxSum = max(maxSum, innerMaxSum)
		outputMaxSum := root.Val + max(left, right) // left,right都是非负的，就不用和0比较了
		return max(outputMaxSum, 0)
	}

	dfs(root)
	return maxSum

}

// func getPathSum(root *TreeNode, maxSum *int) int {
// 	if root == nil {
// 		return math.MinInt32
// 	}

// 	left := getPathSum(root.Left, maxSum)
// 	right := getPathSum(root.Right, maxSum)

// 	currMax := max(max(left + root.Val, right + root.Val), root.Val)
// 	*maxSum = max(*maxSum, max(currMax, left+right+root.Val))
// 	return currMax
// }

func max(a ,b int) int {
	if a > b {
		return a
	}

	return b
}