package leetcode

func spiralOrder(matrix [][]int) []int {

	res := make([]int, 0)

	if len(matrix) == 0 {
		return res
	}

	rowBegin, rowEnd := 0, len(matrix)-1
	colBegin, colEnd := 0, len(matrix[0])-1

	for rowBegin <= rowEnd && colBegin <= colEnd {
		// right
		for i := colBegin; i <= colEnd ; i++ {
			res = append(res, matrix[rowBegin][i])
		}
		rowBegin++
		
		// down
		for j := rowBegin; j <=rowEnd; j++ {
			res = append(res, matrix[j][colEnd])
		}
		colEnd--
		// left
		if rowBegin <= rowEnd {

			for i := colEnd; i >= colBegin; i-- {
				res = append(res, matrix[rowEnd][i])
			}
		}
		rowEnd--

		// up
		if colBegin <= colEnd {

			for j :=rowEnd; j >= rowBegin; j-- {
				res = append(res, matrix[j][colBegin])
			}
		}
		colBegin++
	}
	return res
	
}