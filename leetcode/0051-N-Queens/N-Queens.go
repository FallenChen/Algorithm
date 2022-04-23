package leetcode

import "strings"

var res [][]string

func solveNQueens(n int) [][]string {
	res = [][]string{}
	chessboard := make([][]string, n)
	for i:=0; i<n; i++ {
		chessboard[i] = make([]string, n)
	}

	for i:=0; i<n; i++ {
		for j:=0; j<n; j++ {
			chessboard[i][j] = "."
		}
	}

	backtrack(chessboard,0)

	return res
}

func backtrack(chessboard [][]string, row int) {

	size := len(chessboard)

	if row == size {
		temp := make([]string, size)
		for i, rowStr := range chessboard {
			temp[i] = strings.Join(rowStr, "")
		}
		res = append(res, temp)
		return
	}

	for col:=0; col < size; col++ {
		if isValid(row, col, chessboard){
			chessboard[row][col] = "Q"
			backtrack(chessboard, row+1)
			chessboard[row][col] = "."
		}
	}
}

func isValid(row,col int, chessboard [][]string) bool{
	n := len(chessboard)
	// 检查列
	for i:=0; i<row; i++ {
		if chessboard[i][col] == "Q" {
			return false
		}
	}
	for i := 0; i < n; i++{
		if chessboard[row][i] == "Q" {
		    return false
		}
	}

	// 45度角
	for i,j := row, col; i>=0 && j>=0; i,j = i-1, j-1 {
		if chessboard[i][j] == "Q" {
			return false
		}
	}

	// 135度角
	for i,j := row, col; i>=0 && j<n; i,j = i-1, j+1 {
		if chessboard[i][j] == "Q" {
			return false
		}
	}

	return true;
}





