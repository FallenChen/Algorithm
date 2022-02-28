package leetcode

func sortArray(nums []int) []int {
    quickSort(nums, 0, len(nums)-1)
    return nums
}

func quickSort(nums []int, left, right int)  {
    if left > right {
        return
    }
    q := partition(nums, left, right)
    quickSort(nums, left, q-1)
    quickSort(nums, q+1, right)
    
}

func partition(nums []int, left, right int) int {

    i := left - 1

    for j := left; j < right; j++ {
        if nums[j] <= nums[right] {
            i++
            nums[i], nums[j] = nums[j], nums[i]
        }
    }
    nums[i+1], nums[right] = nums[right], nums[i+1]
    return i + 1
}