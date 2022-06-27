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

	// dp := make([][]int, rows + 1)

	// for i:= range dp {
	// 	dp[i] = make([]int, cols + 1)
	// }
	// maxsqlen := 0;
	// for i:=1; i<=rows; i++ {
	// 	for j:=1; j<=cols; j++ {
	// 		if matrix[i-1][j-1] == '1' {
	// 			dp[i][j] = min(min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1
	// 			maxsqlen = max(maxsqlen, dp[i][j])
	// 		}
	// 	}
	// }
	// return maxsqlen * maxsqlen

	// 以dp(i,j)表示以(i,j)为右下角，且只包含1的正方形的边长最大值

	// 原始矩阵
	// 0 1 1 1 0
	// 1 1 1 1 0
	// 0 1 1 1 1
	// 0 1 1 1 1
	// 0 0 1 1 1

	// dp
	// 0 1 1 1 0
	// 1 1 2 2 0
	// 0 1 2 3 1
	// 0 1 2 3 2
	// 0 0 1 2 3


	dp := make([][]int, len(matrix))
	maxSide := 0

	for i:=0; i<len(matrix); i++ {
		dp[i] = make([]int, len(matrix[i]))
		for j:=0; j<len(matrix[i]); j++ {
			dp[i][j] = int(matrix[i][j] - '0')
			if dp[i][j] == 1 {
				maxSide = 1
			}
		}
	}

	for i:=1; i<len(matrix); i++ {
		for j:=1; j<len(matrix[i]); j++ {
			if dp[i][j] == 1 {
				// 若对于位置 (i, j) 有 f[i][j] = 4，我们将以 (i, j) 为右下角、边长为 4 的正方形
				// 涂上色，可以发现其左侧位置 (i, j - 1)，上方位置 (i - 1, j) 和
				// 左上位置 (i - 1, j - 1) 均可以作为一个边长为 4 - 1 = 3 的正方形的右下角。
				// 也就是说，这些位置的的 f 值至少为 3
				dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
				if dp[i][j] > maxSide {
					maxSide = dp[i][j]
				}
			}
		}
	}

	return maxSide * maxSide


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