package leetcode

// import "sort"
import "fmt"

func findKthLargest(nums []int, k int) int {
	// 1
	// sort.Ints(nums)
	// return nums[len(nums)-k]

	// 2 
	m := len(nums) - k + 1
	return quickSelect(nums, 0, len(nums)-1, m)
}

func quickSelect(nums []int, left, right, i int) int {

	q := partition(nums, left, right)
	k := q - left + 1
	if i == k {
		return nums[q]
	}

	if i < k{
		return quickSelect(nums, left, q-1, i)
	} else {
		return quickSelect(nums, q+1, right, i-k)
	}
}

func partition(nums []int, left,right int) int {

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

func main() {
	nums := []int{3,2,1,5,6,4}
	k := 2
	res := findKthLargest(nums, k)
	fmt.Println(res)
}
	

