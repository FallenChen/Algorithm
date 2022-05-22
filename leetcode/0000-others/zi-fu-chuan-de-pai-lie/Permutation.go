package leetcode

import "sort"


func permutation(s string) []string {
	bytes := []byte(s)
	sort.Slice(bytes, func(i, j int) bool {
		return bytes[i] < bytes[j]
	})
	visited := make([]bool, len(bytes))

	res := make([]string, 0)

	backtracking(bytes, visited, &res, []byte(""))
	return res
}

func backtracking(bytes []byte, visited []bool, res *[]string, tmp []byte) {

	if len(tmp) == len(bytes){
		*res = append(*res, string(tmp))
	}

	for i:=0; i< len(bytes); i++ {
		if visited[i] {
			continue
		}
		if i != 0 && bytes[i] == bytes[i-1] && !visited[i-1] {
			continue
		}
		visited[i] = true
		tmp = append(tmp, bytes[i])
		backtracking(bytes, visited, res, tmp)
		visited[i] = false
		tmp = tmp[:len(tmp)-1]
	}
}