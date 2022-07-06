package leetcode

func reOrderArray(array []int) []int {

	list := make([]int, len(array))

	i := 0

	for _, v := range array {
		if v%2 == 1 {
			list[i] = v
			i++
		}
	}

	for _, v := range array {
		if v%2 == 0 {
			list[i] = v
			i++
		}
	}

	for k, v := range list {
		array[k] = v
	}
	return array

}
