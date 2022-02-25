package leetcode



func lengthOfLongestSubstring(s string) int {
    
	if len(s) == 0 {
		return 0
	}

	var fre [127]int
	// right must start from -1
	left, right, result := 0, -1, 0

	for left < len(s) {
		if right + 1 < len(s) && fre[s[right+1]] == 0 {
			fre[s[right+1]]++
			right++
		} else {
			fre[s[left]]--
			left++
		}
		result = max(result, right-left+1)
	}
	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}