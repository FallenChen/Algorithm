package leetcode

import (
	"algorithm/structures"
)

type TreeNode = structures.TreeNode

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) < 1 {
		return nil
	}

	index := findMax(nums)

	root := &TreeNode{
		Val:   nums[index],
		Left:  constructMaximumBinaryTree(nums[:index]),
		Right: constructMaximumBinaryTree(nums[index+1:]),
	}
	return root
}

func findMax(nums []int) int {
	index := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[index] {
			index = i
		}
	}
	return index
}
