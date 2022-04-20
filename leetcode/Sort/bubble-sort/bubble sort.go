package leetcode


func bubble_sort(nums []int) []int {
	res := []int{}

	if len(nums) == 0 {
		return res
	}

	bubbleSort(nums)

	for _,v :=range nums {
		res = append(res, v)
	}
	return res
}

func bubbleSort(nums []int) {

	for i := len(nums)-1; i>=1; i-- {
		for j :=0; j<i; j++ {
			if nums[j] > nums[j+1] {
				nums[j], nums[j+1] = nums[j+1], nums[j]
			}
		}
	}

}