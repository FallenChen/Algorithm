package leetcode



func LIS( arr []int ) []int {
	if len(arr) == 0 {
	    return nil
	}
	maxLen := make([]int, len(arr))
	res := []int{arr[0]}
	maxLen[0] = 1
	for i := 1; i < len(arr); i++ {
	    if arr[i] > res[len(res)-1] {
		res = append(res, arr[i])
		maxLen[i] = len(res)
	    } else {
		l, r := 0, len(res)-1
		for l < r {
		    mid := l + (r-l)>>1
		    if res[mid] >= arr[i] {
			r = mid
		    } else {
			l = mid+1
		    }
		}
		res[l] = arr[i]
		maxLen[i] = l+1
	    }
	}
	for i, j := len(maxLen)-1, len(res); j > 0; i-- {
	    if maxLen[i] == j {
		j--
		res[j] = arr[i]
	    }
	}
	return res
    }