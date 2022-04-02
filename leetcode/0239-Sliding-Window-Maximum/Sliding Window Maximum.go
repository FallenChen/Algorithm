package leetcode

func maxSlidingWindow(nums []int, k int) []int {

	if len(nums) == 0 || len(nums) < k {
		return make([]int, 0)
	}

	window := make([]int, 0, k) // store the index of nums
	result := make([]int, 0, len(nums)-k+1)

	for i, v := range nums { 
		// if the left-most index is out of window, remove it

		if i >= k  && window[0] <= i-k {
			window = window[1:]
		}
		// maintain window
		for len(window) > 0 && nums[window[len(window) - 1]] < v {
			window = window[0 : len(window) - 1]
		}
		
		window = append(window, i)

		if i >= k-1 {
			result = append(result, nums[window[0]]) // the left-most is the index of max value in nums
		}
	}

	return result
}