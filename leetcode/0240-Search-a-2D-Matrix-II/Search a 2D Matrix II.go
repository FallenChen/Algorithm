package leetcode

func searchMatrix2401(matrix [][]int, target int) bool {
	// if len(matrix) == 0 {
	// 	return false
	// }

	// for _,row := range matrix {
	// 	low, high := 0, len(matrix[0])-1

	// 	for low <= high {
	// 		mid := low + (high - low) /2

	// 		if row[mid] > target {
	// 			high = mid - 1
	// 		} else if row[mid] < target {
	// 			low = mid + 1
	// 		} else {
	// 			return true
	// 		}
	// 	}
	// }

	// return true;

	if matrix == nil || len(matrix) < 1 || len(matrix[0]) < 1 {
		return false
	}

	row,col := 0,len(matrix[0])-1

	for col >=0 && row <= len(matrix)-1 {
		if target == matrix[row][col] {
			return true
		} else if target < matrix[row][col] {
			col--
		} else if target > matrix[row][col] {
			row++
		}
	}
	return false
}