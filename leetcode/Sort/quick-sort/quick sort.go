package leetcode

func quickSort(nums []int) []int {
	res := []int{}
	if len(nums) == 0 {
		return nums
	}

	quickSortRecursive(nums, 0, len(nums)-1)

	for _,v :=range nums {
		res = append(res, v)
	}
	return res
}

func quickSortRecursive(nums []int, start, end int) {
	if start >= end {
		return
	}
	mid := partition(nums, start, end)
	quickSortRecursive(nums, start, mid-1)
	quickSortRecursive(nums, mid+1, end)
}

func partition(nums []int, start, end int) int {

	pivot := nums[start]
	for start < end {
		for start < end && nums[end] >= pivot {
			end--
		}
		nums[start] = nums[end]
		for start < end && nums[start] <= pivot {
			start++
		}
		nums[end] = nums[start]
	}
	nums[start] = pivot
	return start
}