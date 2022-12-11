package leetcode

import (
	"algorithm/structures"
	"testing"
)

func Test_isCompleteTree(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "test",
			args: args{structures.Ints2TreeNode([]int{1, 2, 3, 4, 5, 6})},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isCompleteTree(tt.args.root); got != tt.want {
				t.Errorf("isCompleteTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
