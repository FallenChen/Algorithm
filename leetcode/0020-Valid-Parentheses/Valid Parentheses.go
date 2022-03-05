package leetcode


func isValid(s string) bool {
    
	if s == "" {
		return true
	}

	stack := make([]rune, 0)

	for _, c := range s {
		if c == '(' || c == '[' || c == '{' {
			stack = append(stack, c)
		}else if ((c == ']') && len(stack) > 0 && stack[len(stack)-1] == '[') ||
		((c == ')') && len(stack) > 0 && stack[len(stack)-1] == '(') ||
		((c == '}') && len(stack) > 0 && stack[len(stack)-1] == '{') {
			stack = stack[:len(stack)-1]
		}else {
			return false
		}
	}

	return len(stack) == 0

}