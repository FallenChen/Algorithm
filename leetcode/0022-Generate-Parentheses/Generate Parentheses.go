package leetcode



func generateParenthesis(n int) []string {
    
	if n == 0 {
		return []string{}
	}

	res := []string{}

	findGenerateParenthesis( n, n, "", &res)

	return res

}


func findGenerateParenthesis(lindex,rindex int, str string, res *[]string){
	// str 用于拼接 ( 或 )
	if lindex == 0 && rindex == 0 {
		*res = append(*res, str)
		return 
	}

	if lindex > 0 {
		findGenerateParenthesis(lindex-1, rindex, str+"(", res)
	}

	if rindex > 0 && lindex < rindex {
		findGenerateParenthesis(lindex, rindex-1, str+")", res)
	}
}