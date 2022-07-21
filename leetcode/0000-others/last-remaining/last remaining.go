package leetcode

// nowcoder NC139
func LastRemaining_Solution(n int, m int) int {
	if n == 0 || m == 0 {
		return -1
	}

	res := 0
	for i := 2; i <= n; i++ {
		res = (res + m) % i
	}

	return res
}
