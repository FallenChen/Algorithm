package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func sortedArrayToBST(num []int) *TreeNode {
	cnt := len(num)
	if cnt == 0 {
		return nil
	}

	if cnt == 1 {
		treeNode := new(TreeNode)
		treeNode.Val = num[0]
		return treeNode
	}

	mid := cnt / 2
	treeNode := new(TreeNode)
	treeNode.Val = num[mid]
	treeNode.Left = sortedArrayToBST(num[:mid])
	treeNode.Right = sortedArrayToBST(num[mid+1:])
	return treeNode
}
