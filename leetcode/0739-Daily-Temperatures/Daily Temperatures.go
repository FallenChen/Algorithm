package leetcode


func dailyTemperatures(temperatures []int) []int {

	// res, j := make([]int, len(temperatures)),0

	// for i:=0; i<len(temperatures); i++ {
	// 	for j = i+1; j<len(temperatures); j++ {
	// 		if temperatures[j] > temperatures[i] {
	// 			res[i] = j - i
	// 			break
	// 		}
	// 	} 
	// }
	// return res

	length := len(temperatures)

	ans := make([]int, length)

	stack := []int{}

	for i:=0; i<length; i++ {
		temperature := temperatures[i]
		// 用for而不是if!!!
		for len(stack) > 0 && temperature > temperatures[stack[len(stack) - 1]] {
			prevIndex := stack[len(stack) - 1]
			stack = stack[:len(stack)-1]
			ans[prevIndex] = i - prevIndex
		}
		stack = append(stack, i)
	}
	return ans
}
// 	维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
//	如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
//	[73,74,75,71,69,72,76,73]

//	i = 0
//	stack = [0(73)]
// 	ans = [0,0,0,0,0,0,0,0]

// 	i = 1
//	stack=[1(74)]
//	ans=[1,0,0,0,0,0,0,0]

//	i = 2
//	stack=[2(75)]
//	ans=[1,1,0,0,0,0,0,0]

//	i = 3
//	stack=[2(75),3(71)]
//	ans=[1,1,0,0,0,0,0,0]

//	i = 4
//	stack=[2(75),3(71),4(69)]
//	ans=[1,1,0,0,0,0,0,0]

//	i = 5
//	stack=[2(75),5(72)]
//	ans=[1,1,0,2,1,0,0,0]

//	i = 6
//	stack=[6(76)]
//	ans=[1,1,4,2,1,1,0,0]

//	i= 7
//	stack=[6(76),7(73)]
//	ans=[1,1,4,2,1,1,0,0]