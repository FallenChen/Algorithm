package leetcode

import (
	"algorithm/structures"
	"testing"
)

func Test_sumNumbers(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "test",
			args: args{root: structures.Ints2TreeNode([]int{4, 9, 0, 5, 1})},
			want: 1026,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := sumNumbers(tt.args.root); got != tt.want {
				t.Errorf("sumNumbers() = %v, want %v", got, tt.want)
			}
		})
	}
}
