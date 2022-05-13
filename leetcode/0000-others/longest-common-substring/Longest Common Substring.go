package leetcode


func LCS( str1 string ,  str2 string ) string {

	dp := make([][]int, len(str1) + 1)
    
	for i:= range dp {
	    dp[i] = make([]int, len(str2) + 1)
	}
	
	max := 0
	end := 0
	for i:=1; i< len(str1)+1; i++ {
	    for j:=1; j< len(str2)+1; j++ {
		if str1[i-1] == str2[j-1] {
		    dp[i][j] = dp[i-1][j-1] + 1
		} else {
		    dp[i][j] = 0
		}
		
		if dp[i][j] > max {
		    max = dp[i][j]
		    end = i
		}
	    }
	}
	
	return str1[end-max:end]
}