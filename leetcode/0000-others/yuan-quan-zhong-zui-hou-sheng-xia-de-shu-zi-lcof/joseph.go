package leetcode

func lastRemaining(n int, m int) int {
	return recursion(n,m)
}

func recursion(n,m int) int {
	if n == 1 {
		return 0
	}

	x := recursion(n-1,m)
	return (m + x)%n;

}