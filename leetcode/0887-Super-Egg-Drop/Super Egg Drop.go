package leetcode


func superEggDrop(k int, n int) int {
    dp := make([][]int, n+1)

    for i:= range dp {
	    dp[i] = make([]int, k+1)
    }

    m := 0 

    for dp[m][k] < n {
	    m++
	    for j :=1; j<=k; j++ {
		    dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
	    }
    }
    return m
}