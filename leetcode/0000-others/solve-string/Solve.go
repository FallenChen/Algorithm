package leetcode


func solve( s string ) int {

	stack := make([]int, 0)
	data := []byte(s)
	number := 0
	var operation byte = '+'
	result := 0
	for i:=0;i<len(data);i++{
	    // 0~9
	    if data[i] >= '0' && data[i] <= '9' {
		number = 10*number+int(data[i]-'0')
	    }
     
	    // '('
	    if data[i] == '(' {
		count := 1
		start,end := i+1,i+1
		for count != 0 {
		    if data[end] == '(' {
			count++
		    }
		    if data[end] == ')' {
			count--
		    }
		    end++
		}
		i = end-1
		number = solve(s[start:end-1])
	    }
     
	    // '+'/'-'/'*'
	    if data[i] < '0' || data[i] > '9' || i == len(data)-1 {
		switch operation {
		case '+':
		    stack = append(stack, number)
		case '-':
		    stack = append(stack, -number)
		case '*':
		    stack[len(stack)-1] = stack[len(stack)-1] * number
		}
		number = 0
		operation = data[i]
	    }
	}
     
	for len(stack) != 0{
	    result += stack[len(stack)-1]
	    stack = stack[:len(stack)-1]
	}
	return result

}