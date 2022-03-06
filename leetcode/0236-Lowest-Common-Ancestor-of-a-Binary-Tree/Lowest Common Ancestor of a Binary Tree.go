package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode



func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
  
	if root == nil || root == q || root == p {
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	if left != nil {
		if right != nil {
			return root 
		}
		return left
	}
	return right
}