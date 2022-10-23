package leetcode

import "math"

//type MinStack struct {
//	elements, mins []int
//	length         int
//}
//
//func Constructor() MinStack {
//	return MinStack{make([]int, 0), make([]int, 0), 0}
//}
//
//func (this *MinStack) Push(val int) {
//
//	this.elements = append(this.elements, val)
//
//	if this.length == 0 {
//		this.mins = append(this.mins, val)
//	} else {
//		min := this.GetMin()
//		if val < min {
//			this.mins = append(this.mins, val)
//		} else {
//			this.mins = append(this.mins, min)
//		}
//	}
//	this.length++
//}
//
//func (this *MinStack) Pop() {
//	this.length--
//	this.mins = this.mins[:this.length]
//	this.elements = this.elements[:this.length]
//}
//
//func (this *MinStack) Top() int {
//	return this.elements[this.length-1]
//}
//
//func (this *MinStack) GetMin() int {
//	return this.mins[this.length-1]
//}

type MinStack struct {
	stack []int
	min   int
	size  int
}

func Constructor() MinStack {
	return MinStack{stack: make([]int, 0), min: math.MaxInt64}
}

func (this *MinStack) Push(val int) {
	if this.size == 0 {
		this.min = val
	}
	this.stack = append(this.stack, val-this.min)
	if this.min > val {
		this.min = val
	}
	this.size++
}

func (this *MinStack) Pop() {
	if this.stack[this.size-1] < 0 {
		this.min -= this.stack[this.size-1]
	}
	this.stack = this.stack[:this.size-1]
	this.size--
}

func (this *MinStack) Top() int {
	if this.stack[this.size-1] >= 0 {
		return this.min + this.stack[this.size-1]
	}
	return this.min
}

func (this *MinStack) GetMin() int {
	return this.min
}
