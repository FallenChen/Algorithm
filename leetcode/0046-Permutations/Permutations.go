package leetcode


func permute(nums []int) [][]int {

	if len(nums) == 0 {
		return [][]int{}
	}

	used, path, res := make([]bool, len(nums)), []int{}, [][]int{}
	dfs(&res, path, nums,&used)
	return res
}

func dfs(res *[][]int, tmp, nums []int, used *[]bool) {
	// when len(tmp) == len(nums), add new permutation to res
	if len(tmp) == len(nums) {
		temp := make([]int, len(tmp))
		copy(temp, tmp)
		*res = append(*res, temp)
		return
	}
	for i :=0; i<len(nums); i++ {
		if !(*used)[i] {
			(*used)[i] = true
			tmp = append(tmp, nums[i])
			dfs(res, tmp, nums, used)
			tmp = tmp[:len(tmp)-1]
			(*used)[i] = false
		}
	}
	return
}