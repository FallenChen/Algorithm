package leetcode


func longestPalindrome(s string) string {

	// res, dp := "", make([][]bool, len(s))

	// for i := len(s) -1 ; i>= 0; i-- {
	// 	for j :=i; j<len(s); j++ {
	// 		// least gap is 2, delete i,j,remaning is still palindrome
	// 		dp[i][j] = s[i] == s[j] && ((j - i <=2) || dp[i+1][j-1])
	// 		if dp[i][j] && (res == "" || j - i + 1 > len(res)) {
	// 			res = s[i:j+1]
	// 		}
	// 	}
	// }

	// return res

	if len(s) == 0 {
		return ""
	}

	left, right, pl, pr := 0, -1, 0, 0

	for left < len(s) {
		for right + 1 < len(s) && s[left] == s[right + 1] {
			right++
		}

		for left -1 >= 0 && right + 1 < len(s) && s[left - 1] == s[right + 1] {
			left--
			right++
		}
		if right - left  > pr - pl {
			pl, pr = left, right
		}
		left = (left + right)/2 + 1
		right = left
	}
	return s[pl:pr + 1]
}