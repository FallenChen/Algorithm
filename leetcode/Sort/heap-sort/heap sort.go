package leetcode


func heapSort(nums []int) []int {
	res := []int{}

	if len(nums) == 0 {
		return res
	}

	_heapSort(nums)

	for _,v :=range nums {
		res = append(res, v)
	}
	return res
}

func _heapSort(nums []int) {
	for i:=len(nums)/2-1; i>=0; i-- {
		_heapify(nums, i, len(nums)-1)
	}
	for i:=len(nums)-1; i>=1; i-- {
		nums[0], nums[i] = nums[i], nums[0]
		_heapify(nums, 0, i-1)
	}
}

func _heapify(nums []int, i,end int){
	for i <= end{
		l,r := 2*i+1, 2*i+2
		max := i
		if l <= end && nums[l] > nums[max] {
			max = l
		}
		if r <= end && nums[r] > nums[max] {
			max = r
		}
		if max == i {
			break
		}
		nums[i], nums[max] = nums[max], nums[i]
		i = max
	}
}
