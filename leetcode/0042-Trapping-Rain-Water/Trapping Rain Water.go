package leetcode

func trap(height []int) int {

	// 数组必有一个 ”山顶“（若有多个高度相同山顶，任取一个即可）。
	//
	//根据”木桶原理“，山顶左侧的元素的盛水量 ，由左侧最大值决定；山顶右侧元素的盛水量，由右侧最大值决定。
	//
	//双指针法的两个指针最终会停在 “山顶” 处。
	res, left, right, maxLeft, maxRight := 0, 0, len(height)-1, 0, 0
	for left <= right {
		if height[left] <= height[right] {
			if height[left] > maxLeft {
				maxLeft = height[left]
			} else {
				res += maxLeft - height[left]
			}
			left++
		} else {
			if height[right] >= maxRight {
				maxRight = height[right]
			} else {
				res += maxRight - height[right]
			}
			right--
		}
	}
	return res
}
