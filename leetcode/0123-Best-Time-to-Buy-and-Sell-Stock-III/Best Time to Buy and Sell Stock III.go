package leetcode

func maxProfit(prices []int) int {
	// 未进行过操作
	// 只进行过一次买操作
	// 进行了一次买操作和一次卖操作，即完成了一笔交易
	// 在完成了一笔交易的前提下，进行了第二次买操作
	// 完成了全部两笔交易
	buy1, sell1 := -prices[0], 0
	buy2, sell2 := -prices[0], 0
	for i := 1; i < len(prices); i++ {
		buy1 = max(buy1, -prices[1])
		sell1 = max(sell1, buy1+prices[i])
		buy2 = max(buy2, sell1-prices[i])
		sell2 = max(sell2, buy2+prices[i])
	}
	return sell2
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
