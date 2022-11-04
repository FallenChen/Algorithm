package leetcode

import (
	"fmt"
	"testing"
)

func Test_Trie(t *testing.T) {
	trie := Constructor()
	trie.Insert("apple")
	result := trie.Search("apple")
	fmt.Println("is found", result)
	result2 := trie.Search("app")
	fmt.Println("search is found", result2)
	with := trie.StartsWith("app")
	fmt.Println("is found", with)
}
