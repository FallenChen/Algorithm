package leetcode

func calculate(s string) int {

	var stack []int
	res, num, preSign := 0, 0, '+'

	for i, ch := range s {
		isDigit := '0' <= ch && ch <= '9'

		// 考虑位数的情况，比如12，ch为1，2。所以需要进位法
		if isDigit {
			num = num*10 + int(ch-'0')
		}

		if !isDigit && ch != ' ' || i == len(s)-1 {
			switch preSign {
			case '+':
				stack = append(stack, num)
			case '-':
				stack = append(stack, -num)
			case '*':
				stack[len(stack)-1] *= num
			default:
				stack[len(stack)-1] /= num
			}
			num = 0
			preSign = ch
		}

	}
	for _, v := range stack {
		res += v
	}

	return res
}
