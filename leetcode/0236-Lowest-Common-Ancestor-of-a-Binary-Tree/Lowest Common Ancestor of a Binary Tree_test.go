package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_lowestCommonAncestor(t *testing.T) {
	type args struct {
		root *TreeNode
		p    *TreeNode
		q    *TreeNode
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "test",
			args: args{root: structures.Ints2TreeNode([]int{4, 5, 1, 6, 2, 0, 8, structures.NULL, structures.NULL, 7, 4}), p: structures.Ints2TreeNode([]int{5}), q: structures.Ints2TreeNode([]int{1})},
			want: structures.Ints2TreeNode([]int{3}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := lowestCommonAncestor(tt.args.root, tt.args.p, tt.args.q); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("lowestCommonAncestor() = %v, want %v", got, tt.want)
			}
		})
	}
}
