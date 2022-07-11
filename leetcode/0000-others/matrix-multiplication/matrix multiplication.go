package leetcode

// https://www.nowcoder.com/practice/bf358c3ac73e491585943bac94e309b0?tpId=117&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
func solve(a [][]int, b [][]int) [][]int {

	res := make([][]int, len(a))
	for i := 0; i < len(a); i++ {
		res[i] = make([]int, len(b[0]))
	}

	for i := 0; i < len(a); i++ {
		for j := 0; j < len(b[0]); j++ {
			temp := 0
			for k := 0; k < len(a[0]); k++ {
				temp += a[i][k] * b[k][j]
			}
			res[i][j] = temp
		}
	}
	return res
}
