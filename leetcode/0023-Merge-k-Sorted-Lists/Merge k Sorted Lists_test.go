package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_mergeKLists(t *testing.T) {
	type args struct {
		lists []*ListNode
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			name: "test",
			args: args{
				[]*ListNode{structures.Ints2List([]int{1, 4, 5}), structures.Ints2List([]int{1, 3, 4}), structures.Ints2List([]int{2, 6})},
			},
			want: structures.Ints2List([]int{1, 1, 2, 3, 4, 4, 5, 6}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := mergeKLists(tt.args.lists); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("mergeKLists() = %v, want %v", got, tt.want)
			}
		})
	}
}
