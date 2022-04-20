package leetcode

import (
	"fmt"
	"testing"
)


func Test_bubble_sort(t *testing.T){
	nums := []int{3,7,1,5,2,4}
	res := bubble_sort(nums)
	for _,v := range res {
		fmt.Println(v)
	}
}