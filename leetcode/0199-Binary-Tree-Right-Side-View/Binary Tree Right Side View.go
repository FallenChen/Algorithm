package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func rightSideView(root *TreeNode) []int {

	res := []int{}

	// res := []int{}
	// if root == nil {
	// 	return res
	// }

	// queue := []*TreeNode{root}

	// for len(queue) > 0 {
	// 	n := len(queue)

	// 	for i:=0; i<n; i++ {
	// 		if queue[i].Left != nil {
	// 			queue = append(queue, queue[i].Left)
	// 		}
	// 		if queue[i].Right != nil {
	// 			queue = append(queue, queue[i].Right)
	// 		}
	// 	}
	// 	res = append(res, queue[n-1].Val)
	// 	queue = queue[n:]
	// }
	// return res

	rightView(root, &res, 0)
	return res
}

func rightView(root *TreeNode, res *[]int, deep int) {

	if root == nil {
		return
	}

	if deep == len(*res) {
		*res = append(*res, root.Val)
	}

	rightView(root.Right, res, deep+1)
	rightView(root.Left, res, deep+1)


	// if deep == len(res) {
	// 	res = append(res, root.Val)
	// }

	// rightView(root.Left, res, deep+1)
	// rightView(root.Right, res,deep+1)
}

