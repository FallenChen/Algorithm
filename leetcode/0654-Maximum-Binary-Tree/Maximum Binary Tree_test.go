package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_constructMaximumBinaryTree(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "test",
			args: args{nums: []int{3, 2, 1, 6, 0, 5}},
			want: structures.Ints2TreeNode([]int{6, 3, 5, structures.NULL, 2, 0, structures.NULL, structures.NULL, 1}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := constructMaximumBinaryTree(tt.args.nums); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("constructMaximumBinaryTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
