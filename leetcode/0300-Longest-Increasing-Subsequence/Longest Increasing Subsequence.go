package leetcode



func lengthOfLIS(nums []int) int {
 
	// dp, res := make([]int, len(nums) + 1) , 0

	// dp[0] = 0;
	// for i:=1; i<=len(nums); i++ {
	// 	for j:=1; j<i; j++{
	// 		if nums[j-1] < nums[i-1]{
	// 			dp[i] = max(dp[i], dp[j])
	// 		}
	// 	}
	// 	dp[i] = dp[i] + 1
	// 	res = max(res, dp[i])
	// }
	// return res

	tails,res := make([]int, len(nums)),0
	for _, num := range nums {
		i,j := 0,res
		for i != j {
			m := (i+j)/2
			if tails[m] < num {
				i = m + 1
			}else{
				j = m;
			}
		}
		tails[i] = num;
		if i == res {
			res += 1
		}
	}
	return res
}

func max(a ,b int) int {
	if a > b {
		return a
	}
	return b
}