package leetcode

import (
	"fmt"
	"testing"
)

func Test_findKthLargest(t *testing.T) {
	nums := []int{3,2,1,5,6,4}
	k := 2
	res := findKthLargest(nums, k)
	fmt.Println(res)
}