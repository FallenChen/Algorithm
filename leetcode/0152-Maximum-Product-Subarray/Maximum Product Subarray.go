package leetocde

func maxProduct(nums []int) int {

	minNum,maxNum,res := nums[0],nums[0],nums[0]

	for i:=1; i<len(nums); i++ {
		if nums[i] < 0 {
			maxNum,minNum = minNum, maxNum
		}
		maxNum = max(nums[i], maxNum*nums[i])
		minNum = min(nums[i], minNum*nums[i])
		res = max(res, maxNum)
	}
	return res
}

func max(a,b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a,b int) int {
	if a > b {
		return b
	}
	return a
}