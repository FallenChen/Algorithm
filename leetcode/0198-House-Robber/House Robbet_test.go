package leetcode

import (
	"fmt"
	"testing"
)

func Test_house_ro(t *testing.T){
	var nums []int
	nums = []int{2,7,9,3,1}

	res := rob(nums)

	fmt.Println(res)
}