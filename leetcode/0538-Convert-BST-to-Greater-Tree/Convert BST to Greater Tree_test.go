package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_convertBST(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "test",
			args: args{root: structures.Ints2TreeNode([]int{3, 2, 4, 1})},
			want: structures.Ints2TreeNode([]int{7, 9, 4, 10}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := convertBST(tt.args.root); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("convertBST() = %v, want %v", got, tt.want)
			}
		})
	}
}
