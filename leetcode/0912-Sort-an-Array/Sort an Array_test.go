package leetcode

import (
	"fmt"
	"testing"
)

func Test_sortArray(t *testing.T) {
	nums := []int{3,7,1,5,2,4}
	res := sortArray(nums)
	fmt.Println(res)
}