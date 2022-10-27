package leetcode

import "testing"

func Test_majorityElement(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "test",
			args: args{nums: []int{2, 2, 1, 1, 1, 2, 2}},
			want: 2,
		},
		{
			name: "test2",
			args: args{nums: []int{1, 1, 2, 2, 2, 3, 3}}, // 注：题意为超过n/2，在这里即是超过3，数组不符合要求
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := majorityElement(tt.args.nums); got != tt.want {
				t.Errorf("majorityElement() = %v, want %v", got, tt.want)
			}
		})
	}
}
