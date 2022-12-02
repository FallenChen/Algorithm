package leetcode

import (
	"algorithm/structures"
	"testing"
)

func Test_widthOfBinaryTree(t *testing.T) {
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
			args: args{root: structures.Ints2TreeNode([]int{1, 3, 2, 5, 3, structures.NULL, 9})},
			want: 4,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := widthOfBinaryTree(tt.args.root); got != tt.want {
				t.Errorf("widthOfBinaryTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
