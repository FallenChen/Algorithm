package leetcode

import (
	"fmt"
	"testing"
)

func Test_N_Queens(t *testing.T){
	
	n := 4
	
	board := solveNQueens(n)

	// fomrt the result
	for _, row := range board {
		fmt.Println(row)
	}
}