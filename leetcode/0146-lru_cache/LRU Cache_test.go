package leetcode

import (
	"fmt"
	"os"
	"testing"
)

var lruCache LRUCache

func setup() {
	fmt.Println("Before all tests")
	lruCache = Constructor(2)
	lruCache.Put(1, 1)
	lruCache.Put(2, 2)
}

func teardown() {
	fmt.Println("After all tests")
}

func Test1(t *testing.T) {
	fmt.Println("I'm test1")
	get := lruCache.Get(1)
	fmt.Println(get)
	lruCache.Put(3, 3)
	fmt.Println(lruCache.Get(2))
	lruCache.Put(4, 4)
	fmt.Println(lruCache.Get(1))
	fmt.Println(lruCache.Get(3))
	fmt.Println(lruCache.Get(4))
}

func TestMain(m *testing.M) {
	setup()
	code := m.Run()
	teardown()
	os.Exit(code)
}
