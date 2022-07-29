package leetcode

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	// 凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0;
	dp[0] = 0

	// 必须是最大值，否则在推导过程中会覆盖
	for i := 1; i < len(dp); i++ {
		dp[i] = amount + 1
	}

	for i := 1; i <= amount; i++ {
		for j := 0; j < len(coins); j++ {
			if coins[j] <= i {
				// 为凑足总额为j所需钱币的最小个数为dp[j]
				dp[i] = min(dp[i], dp[i-coins[j]]+1)
			}
		}
	}
	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {

	if a > b {
		return b
	}
	return a
}
