package leetcode

func longestConsecutive(nums []int) int {

	// res, numMap := 0, map[int]int{}

	// for _,num :=range nums {
	// 	if numMap[num] == 0 {
	// 		left, right, len := 0,0,0

	// 		if numMap[num-1] > 0 {
	// 			left = numMap[num-1]
	// 		} else {
	// 			left = 0
	// 		}
	// 		if numMap[num+1] > 0 {
	// 			right = numMap[num+1]
	// 		} else {
	// 			right = 0
	// 		}

	// 		len = left + right + 1
	// 		numMap[num] = len

	// 		res = max(res, len)
	// 		numMap[num-left] = len
	// 		numMap[num+right] = len
	// 	} else {
	// 		continue
	// 	}
	// }
	// return res

	numSet := map[int]bool{}
	for _, num := range nums {
		numSet[num] = true
	}
	res := 0 
	for num := range numSet {
		if !numSet[num-1]{
			currentNum := num
			currentStreak := 1
			for numSet[currentNum + 1]{
				currentNum++
				currentStreak++
			}
			if res < currentStreak {
				res = currentStreak
			}
		}
	}
	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}