package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func isSymmetric(root *TreeNode) bool {
    
	if root == nil {
		return true
	}

	return isMirror(root.Left, root.Right)
}

func isMirror(left *TreeNode, right *TreeNode) bool {

	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	return (left.Val == right.Val) && 
		// left outside == right outside  
		isMirror(left.Left, right.Right) && 
		// left inside == right inside
		isMirror(left.Right, right.Left)
}