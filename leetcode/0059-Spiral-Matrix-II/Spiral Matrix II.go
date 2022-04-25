package leetcode

func generateMatrix(n int) [][]int {

	matrix := make([][]int,n)

	for i:=0; i<n; i++ {
		matrix[i] = make([]int, n)
	}

	left, right , top, down := 0,n-1, 0, n-1

	count := 1

	for left <= right {
		// top left to right
		for i:= left; i<=right; i++ {
			matrix[top][i] = count
			count++
		}
		top++

		// right top to down
		for i:= top; i<=down; i++ {
			matrix[i][right] = count
			count++
		}
		right--

		// down right to left 
		for i:=right; i>= left; i-- {
			matrix[down][i] = count
			count++
		}
		down--;

		// left down to top
		for i:=down; i>= top; i-- {
			matrix[i][left] = count
			count++
		}
		left++
	}

	return matrix

}