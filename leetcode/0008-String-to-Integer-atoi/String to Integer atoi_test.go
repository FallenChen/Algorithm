package leetcode

import (
	"fmt"
	"testing"
)

func Test_myAtoi(t *testing.T) {
	var nums string
	nums = "-000.642"
	fmt.Println(myAtoi(nums))
}