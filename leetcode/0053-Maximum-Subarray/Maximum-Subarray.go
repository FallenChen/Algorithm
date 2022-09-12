package leetcode

func maxSubArray(nums []int) int {

	// old
	//dp := make([]int, len(nums))
	//dp[0] = nums[0]
	//
	//maxSoFar := nums[0]
	//for i := 1; i < len(nums); i++ {
	//	dp[i] = max(dp[i-1]+nums[i], nums[i])
	//	maxSoFar = max(maxSoFar, dp[i])
	//}

	// new
	maxSoFar := nums[0]
	maxEndingHere := nums[0]

	for i := 1; i < len(nums); i++ {
		maxEndingHere = max(nums[i], maxEndingHere+nums[i])
		maxSoFar = max(maxSoFar, maxEndingHere)
	}

	return maxSoFar
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
