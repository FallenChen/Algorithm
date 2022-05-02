package leetcode

import "algorithm/structures"


type TreeNode = structures.TreeNode


func levelOrderBottom(root *TreeNode) [][]int {
	
	result := make([][]int, 0)

	level := 0

	if root == nil {
		return result
	}

	dfs(root,&result, level)

	for i:=0; i<len(result)/2; i++ {
		result[i], result[len(result)-i-1] = result[len(result)-i-1], result[i]
	}
	return result
}

func dfs(root *TreeNode, result *[][]int, level int) {

	if root == nil {
		return 
	}

	if len(*result) <= level {
		*result = append(*result, []int{root.Val})
	}else {
		(*result)[level] = append((*result)[level], root.Val)
	}

	dfs(root.Left, result, level+1)
	dfs(root.Right, result, level+1)
}