package leetcode

import (
	"fmt"
	"testing"
)

func Test_Implement_strStr(t *testing.T){

	haystack := "aabaabaafa"
	needle := "aacdef"

	result := strStr(haystack, needle)

	fmt.Println(result)
}