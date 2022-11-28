package leetcode

import (
	"algorithm/structures"
	"testing"
)

func Test_isSubtree(t *testing.T) {
	type args struct {
		root    *TreeNode
		subRoot *TreeNode
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "test",
			args: args{root: structures.Ints2TreeNode([]int{3, 4, 5, 1, 2}), subRoot: structures.Ints2TreeNode([]int{4, 1, 2})},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isSubtree(tt.args.root, tt.args.subRoot); got != tt.want {
				t.Errorf("isSubtree() = %v, want %v", got, tt.want)
			}
		})
	}
}
