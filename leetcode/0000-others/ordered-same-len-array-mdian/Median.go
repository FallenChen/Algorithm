package leetcode

func findMedianinTwoSortedAray( arr1 []int ,  arr2 []int ) int {
	// write code here
	
	if arr1 == nil || arr2 == nil || len(arr1) != len(arr2) {
	    return 0
	}
	
	left1, right1, left2, right2, mid1, mid2, offset := 0, len(arr1)-1, 0, len(arr2)-1, 0, 0, 0
	
	for left1 < right1 {
	    mid1 = left1 + (right1 - left1)/2
	    mid2 = left2 + (right2 - left2)/2
	    offset = ((right1 - left1 + 1)&1)^1
	    
	    if arr1[mid1] > arr2[mid2] {
		right1 = mid1
		left2 = mid2 + offset
	    } else if arr1[mid1] < arr2[mid2] {
		right2 = mid2
		left1 = mid1 + offset
	    } else {
		return arr1[mid1]
	    }
	}
	return min(arr1[left1], arr2[left2])
    }
    
    func min(a int, b int) int {
	    if a > b {
		    return b
	    }
	    return a
    }