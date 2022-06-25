package leetcode

import (
	"fmt"
	"testing"
)

func TestReverPair(t *testing.T) {
	arr := []int{1, 2, 3, 4, 5, 0}
	cnt := reversePairs(arr)
	fmt.Println(cnt)

}
