package leetcode

func subsets(nums []int) [][]int {

	arr, res :=[]int{}, [][]int{}
	for k:=0; k<=len(nums); k++ {
		dfs(nums, k, 0, arr, &res)
	}
	return res;
}

func dfs(nums []int, k, start int, arr []int, res *[][]int) {
	if len(arr) == k {
		b := make([]int, len(arr))
		copy(b,arr)
		*res = append(*res, b)
		return
	}

	for i:= start; i<len(nums) - (k - len(arr)) + 1; i++ {
		arr = append(arr, nums[i])
		dfs(nums, k, i+1, arr, res)
		arr = arr[:len(arr) - 1]
	}
}