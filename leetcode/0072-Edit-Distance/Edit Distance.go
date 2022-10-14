package leetcode

// todo hard
func minDistance(word1 string, word2 string) int {

	l1, l2 := len(word1), len(word2)
	// init [l1][l2] array
	dp := make([][]int, l1+1)
	for i := 0; i <= l1; i++ {
		dp[i] = make([]int, l2+1)
	}
	// empty case
	for i := 1; i <= l1; i++ {
		dp[i][0] = i
	}
	for j := 1; j <= l2; j++ {
		dp[0][j] = j
	}

	for i := 1; i <= l1; i++ {
		for j := 1; j <= l2; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				// word1[i-1] != word2[j-1]
				// replace word1[i-1] by word2[j-1]  dp[i][j] = dp[i-1][j-1] + 1
				// if word1[0..i-1) = word2[0..j) then delete word1[i-1] (dp[i][j] = dp[i-1][j] + 1)
				// if word1[0..i) + word2[j-1] = word2[0..j) then insert word2[j-1] (dp[i][j] = dp[i][j-1] + 1)
				dp[i][j] = min(min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1
			}
		}
	}
	return dp[l1][l2]

}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
