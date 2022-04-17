package leetcode

import (
	"algorithm/structures"
	"testing"
)


type question138 struct {
	para138
	ans138
}


// para 是参数
// one 代表第一个参数
type para138 struct {
	head [][]int
}

// ans 是答案
// one 代表第一个答案
type ans138 struct {
	one [][]int
}

func Test_Problem138(t *testing.T){

	
	qs := []question138{

		{
			para138{[][]int{{1, 2}, {2, 3}, {3, structures.NULL}, {4, structures.NULL}}},
			ans138{[][]int{{1, 2}, {2, 3}, {3, structures.NULL}, {4, structures.NULL}}},
		},

	}

	for _,q := range qs {
		_, p := q.ans138, q.para138
		copyRandomList(ints2Node(p.head))
	}



}


func ints2Node(one [][]int) *Node {
	nodesMap := map[int]*Node{}
	for index, nodes := range one {
		tmp := &Node{Val: nodes[0]}
		nodesMap[index] = tmp
	}
	for index, node := range nodesMap {
		if index != len(one)-1 {
			node.Next = nodesMap[index+1]
		} else {
			node.Next = nil
		}
	}
	for index, nodes := range one {
		if nodes[1] == structures.NULL {
			nodesMap[index].Random = nil
		} else {
			nodesMap[index].Random = nodesMap[nodes[1]]
		}
	}
	return nodesMap[0]
}