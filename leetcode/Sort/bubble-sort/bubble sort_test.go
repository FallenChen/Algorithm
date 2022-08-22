package leetcode

import (
	"reflect"
	"testing"
)

func Test_bubble_sort(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "test",
			args: args{[]int{3, 2, 6, 4, 7, 8}},
			want: []int{2, 3, 4, 6, 7, 8},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := bubble_sort(tt.args.nums); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("bubble_sort() = %v, want %v", got, tt.want)
			}
		})
	}
}
