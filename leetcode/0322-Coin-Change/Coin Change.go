package leetcode

func coinChange(coins []int, amount int) int {
    dp := make([]int, amount+1)
    dp[0] = 0

    for i:= 1; i< len(dp); i++ {
	    dp[i] = amount + 1
    }

    for i:=1; i<= amount; i++ {
	    for j:=0; j<len(coins); j++ {
		    if coins[j] <= i {
			    // dp[j] 为凑足总额为j所需钱币的最小个数为dp[j]
			    // 然后再确定dp数组初始化，必须初始化为最大的数，否则会被覆盖
			    dp[i] = min(dp[i], dp[i-coins[j]] + 1)
		    }
	    }
    }
    if dp[amount] > amount {
	    return -1
    }
    return dp[amount]
}

func min(a,b int) int {

	if a > b {
		return b
	}
	return a
}