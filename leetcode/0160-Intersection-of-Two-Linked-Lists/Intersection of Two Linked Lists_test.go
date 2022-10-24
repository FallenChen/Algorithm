package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_getIntersectionNode(t *testing.T) {
	type args struct {
		headA *ListNode
		headB *ListNode
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			// todo
			name: "test1",
			args: args{headA: structures.Ints2List([]int{1, 9, 1, 2, 4}), headB: structures.Ints2List([]int{3, 2, 4})},
			want: structures.Ints2List([]int{2, 4}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getIntersectionNode(tt.args.headA, tt.args.headB); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("getIntersectionNode() = %v, want %v", got, tt.want)
			}
		})
	}
}
