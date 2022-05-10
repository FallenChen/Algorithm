package leetcode

func maxLength( arr []int ) int {

	maxLen , len, left := 0,0,-1

	h := make(map[int]int)

	for idx, right := range arr {
		if valueIdx, ok := h[right]; !ok || h[right] == -1 {
			len++
		} else {
			if valueIdx > left {
				left = valueIdx
			}
			len = idx - left
		}
		h[right] = idx

		if maxLen < len {
			maxLen = len
		}
	}

	return maxLen
}