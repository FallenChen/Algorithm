package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_buildTree(t *testing.T) {
	type args struct {
		inorder   []int
		postorder []int
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "test",
			args: args{inorder: []int{9, 3, 15, 20, 7}, postorder: []int{9, 15, 7, 20, 3}},
			want: structures.Ints2TreeNode([]int{3, 9, 20, structures.NULL, structures.NULL, 15, 7}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := buildTree(tt.args.inorder, tt.args.postorder); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("buildTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
