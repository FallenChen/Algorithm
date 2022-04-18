package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode



func widthOfBinaryTree(root *TreeNode) int {

	lefts := []int{}

	return dfs(root,1,0,&lefts)
}

func dfs(root *TreeNode, id,depth int, lefts *[]int) int {
	if root == nil {
		return 0
	}
	if depth >= len(*lefts) {
		*lefts = append(*lefts,id)
	}

	return max(id + 1 - (*lefts)[depth], max(dfs(root.Left, id*2, depth+1, lefts), 
					  dfs(root.Right, id*2+1, depth+1, lefts)))

}

func max(a,b int) int {
	if a > b {
		return a
	}
	return b
}

