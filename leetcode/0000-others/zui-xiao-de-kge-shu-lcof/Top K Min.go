package leetcode

func getLeastNumbers(arr []int, k int) []int {

	var quick func(nums []int, left, right int) []int 
	quick = func(nums []int, left, right int) []int {
		if left > right {
			return nil
		}

		i, j, pivot := left, right, nums[left]

		for i < j {

			for i < j && nums[j] >= pivot {
				j--
			}

			for i < j && nums[i] <= pivot {
				i++
			}

			// 大小位置不正确的，交换
			nums[i], nums[j] = nums[j], nums[i]
		}
		nums[i], nums[left] = nums[left], nums[i]
		quick(nums, left, i-1)
		quick(nums, i+1, right)
		return nums
	}

	nums := quick(arr, 0, len(arr)-1)
	
	return nums[:k]
}