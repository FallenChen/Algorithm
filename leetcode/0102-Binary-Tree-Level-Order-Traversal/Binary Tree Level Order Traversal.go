package leetcode

import "algorithm/structures"


type TreeNode = structures.TreeNode


func levelOrder(root *TreeNode) [][]int {
    
	var res [][]int
	var dfs func(root *TreeNode, level int)
	dfs = func(root *TreeNode, level int) {
		if root == nil {
			return
		}
		level++
		if len(res) < level {
			res = append(res, []int{})
		}
		res[level-1] = append(res[level-1], root.Val)
		dfs(root.Left, level)
		dfs(root.Right, level)
	}
	dfs(root, 0)

	return res
}
