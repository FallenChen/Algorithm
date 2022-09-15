package leetcode

func uniquePaths(m int, n int) int {

	//dp := make([][]int, n)
	//
	//for i:=0; i<n; i++ {
	//	dp[i] = make([]int, m)
	//}
	//
	//for i:=0; i<n; i++ {
	//	for j:=0; j<m; j++ {
	//		if j==0 || i==0 {
	//			dp[i][j] = 1
	//			continue
	//		}
	//		dp[i][j] = dp[i-1][j] + dp[i][j-1]
	//	}
	//}
	//return dp[n-1][m-1]

	// todo
	dp := make([]int, n)

	for i := 0; i < n; i++ {
		dp[i] = 1
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[j] += dp[j-1]
		}
	}
	return dp[n-1]
}
