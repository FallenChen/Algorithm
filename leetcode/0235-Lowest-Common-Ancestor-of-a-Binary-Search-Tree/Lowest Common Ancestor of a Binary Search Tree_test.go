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
			args: args{root: structures.Ints2TreeNode([]int{6, 2, 8, 0, 4, 7, 9, structures.NULL, structures.NULL, 3, 5}), p: structures.Ints2TreeNode([]int{2}), q: structures.Ints2TreeNode([]int{8})},
			want: structures.Ints2TreeNode([]int{6}),
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
