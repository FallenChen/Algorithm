package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_levelOrder(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		{name: "unittest",
			args: args{structures.Ints2TreeNode([]int{3, 9, 20, 15, structures.NULL, structures.NULL, 7})},
			want: [][]int{{3}, {9, 20}, {15, 7}}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := levelOrder(tt.args.root); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("levelOrder() = %v, want %v", got, tt.want)
			}
		})
	}
}
