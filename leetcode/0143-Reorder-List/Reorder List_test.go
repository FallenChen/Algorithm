package leetcode

import (
	"algorithm/structures"
	"testing"
)

func Test_reorderList(t *testing.T) {
	type args struct {
		head *ListNode
	}
	tests := []struct {
		name string
		args args
	}{
		{
			name: "test1",
			args: args{head: structures.Ints2List([]int{1, 2, 3, 4})},
		},
		{
			name: "test2",
			args: args{head: structures.Ints2List([]int{1, 2, 3, 4, 5})}, // 1,5,2,4,3
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			reorderList(tt.args.head)
		})
	}
}
