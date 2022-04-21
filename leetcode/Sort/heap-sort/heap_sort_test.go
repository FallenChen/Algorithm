package leetcode

import (
	"fmt"
	"testing"
)


func Test_heap_sort(t *testing.T){
	nums := []int{3,2,1,5,6,4}
	res := heapSort(nums)
	for _,v:=range res {
		fmt.Println(v)
	}
}