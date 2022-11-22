package leetcode

// todo
func findDiagonalOrder(mat [][]int) []int {

	row := len(mat)
	col := len(mat[0])

	var result []int

	for i := 0; i < row+col+1; i++ {
		if (i % 2) != 1 {
			for j := max(0, i-row+1); j <= min(i, col-1); j++ {
				result = append(result, mat[i-j][j])
			}
		} else {
			for j := min(i, col-1); j >= max(0, i-row+1); j-- {
				result = append(result, mat[i-j][j])
			}
		}
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
