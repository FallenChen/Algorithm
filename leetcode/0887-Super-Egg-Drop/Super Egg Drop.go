package leetcode


func superEggDrop(k int, n int) int {

    dp, step := make([]int, k+1), 0 

    for ; dp[k] < n; step++ {
        for i:=k; i>0; i-- {
            dp[i] = 1 + dp[i] + dp[i-1]
        }
    }
    return step
}