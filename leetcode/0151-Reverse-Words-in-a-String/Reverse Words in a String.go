package leetcode

import "strings"

func reverseWords(s string) string {
    
	ss := strings.Fields(s)

	reverse(&ss, 0 ,len(ss)-1)

	return strings.Join(ss, " ")
}

func reverse(ss *[]string, start, end int) {
	for start < end {
		(*ss)[start], (*ss)[end] = (*ss)[end], (*ss)[start]
		start++
		end--
	}
}