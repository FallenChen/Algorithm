package leetcode


func solve( M int ,  N int ) string {

	sign := false
	if M < 0 {
	    sign = true
	    M = -M
	}
	
	if M < 0 {
	    M = -M
	}
	
	var ret string
	
	for M > 0 {
	    mod := M%N
	    var a byte
	    if mod <= 9 {
		a = '0' + byte(mod)
	    } else {
		a = 'A' + byte(mod-10)
	    }
	    
	    ret = string(a) + ret
	    M = M/N
	}
	
	if sign {
	    ret = "-" + ret
	}
	
	return ret
}