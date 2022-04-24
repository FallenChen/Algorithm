package leetcode

import (
	"fmt"
	"testing"
)


func Test_sliding_window(t *testing.T){
	nums := []int{1,3,-1,-3,5,3,6,7}

	res := maxSlidingWindow(nums,3)

	for _,v:=range res {
		fmt.Print(v)
	}
}