package leetcode



func maximalSquare(matrix [][]byte) int {
    
	rows,cols := len(matrix), len(matrix[0])

	// maxsqlen := 0

	// for i:=0; i<rows; i++ {
	// 	for j:=0; j<cols;j++ {
	// 		if(matrix[i][j] == '1') {
	// 			sqlen := 1;
	// 			flag := true
	// 			for sqlen + i < rows && sqlen + j < cols && flag {
	// 				for  k:=j; k <= sqlen+j; k++ {
	// 					if(matrix[i+sqlen][k] == '0') {
	// 						flag = false
	// 						break;
	// 					}
	// 				}

	// 				for  k:=i; k <= sqlen+i; k++ {
	// 					if(matrix[k][j+sqlen] == '0') {
	// 						flag = false
	// 						break;
	// 					}
	// 				}

	// 				if(flag) {
	// 					sqlen++
	// 				}
	// 			}
	// 			if (maxsqlen < sqlen){
	// 				maxsqlen = sqlen
	// 			}
	// 		}
	// 	}
	// }

	dp := make([][]int, rows + 1)

	for i:= range dp {
		dp[i] = make([]int, cols + 1)
	}
	maxsqlen := 0;
	for i:=1; i<=rows; i++ {
		for j:=1; j<=cols; j++ {
			if matrix[i-1][j-1] == '1' {
				dp[i][j] = min(min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1
				maxsqlen = max(maxsqlen, dp[i][j])
			}
		}
	}
	return maxsqlen * maxsqlen
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}