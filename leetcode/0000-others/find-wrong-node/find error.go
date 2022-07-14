package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func findError(root *TreeNode) []int {
	aux := []int{}
	midTrans(root, &aux)
	res := []int{}

	for i := len(aux) - 1; i > 0; i-- {
		if aux[i] < aux[i-1] {
			res = append(res, aux[i])
			break
		}
	}

	for i := 0; i < len(aux)-1; i++ {
		if aux[i] > aux[i+1] {
			res = append(res, aux[i])
			break
		}
	}
	return res
}

func midTrans(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	midTrans(root.Left, res)
	*res = append(*res, root.Val)
	midTrans(root.Right, res)
}
