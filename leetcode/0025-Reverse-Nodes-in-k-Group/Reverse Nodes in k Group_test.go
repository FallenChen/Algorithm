package leetcode

import (
	"algorithm/structures"
	"reflect"
	"testing"
)

func Test_reverseKGroup(t *testing.T) {
	type args struct {
		head *ListNode
		k    int
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			name: "test1",
			args: args{k: 2, head: structures.Ints2List([]int{1, 2, 3, 4, 5})},
			want: structures.Ints2List([]int{2, 1, 4, 3, 5}),
		},
		{
			name: "test2",
			args: args{k: 2, head: structures.Ints2List([]int{1, 2, 3, 4, 5, 6})},
			want: structures.Ints2List([]int{2, 1, 4, 3, 6, 5}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := reverseKGroup(tt.args.head, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("reverseKGroup() = %v, want %v", got, tt.want)
			}
		})
	}
}
