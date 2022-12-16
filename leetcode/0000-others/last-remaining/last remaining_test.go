package leetcode

import "testing"

func TestLastRemainingSolution(t *testing.T) {
	type args struct {
		n int
		m int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{name: "testcase", args: args{n: 5, m: 3}, want: 3},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := LastremainingSolution(tt.args.n, tt.args.m); got != tt.want {
				t.Errorf("LastRemaining_Solution() = %v, want %v", got, tt.want)
			}
		})
	}
}
