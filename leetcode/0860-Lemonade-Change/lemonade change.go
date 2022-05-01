package leetcode

func lemonadeChange(bills []int) bool {
	five, ten := 0,0

	for i:=0; i<len(bills); i++ {
		if bills[i] == 5 {
			five++
		}else if bills[i] == 10 {
			five--
			ten++
		}else if bills[i] == 20 {
			if ten > 0 {
				ten--
				five--
			}else {
				five -= 3
			}
		}
		if five < 0 || ten < 0 {
			return false
		}
	}
	return true
}