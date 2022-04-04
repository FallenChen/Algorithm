package leetcode

type MinStack struct {
    elements,min	[]int
    length		int
}


func Constructor() MinStack {
    return MinStack{make([]int, 0), make([]int, 0), 0}
}


func (this *MinStack) Push(val int)  {
    
	this.elements = append(this.elements, val)

	if this.length == 0 {
		this.min = append(this.min, val)
	} else {
		min := this.GetMin()
		if val < min {
			this.min = append(this.min, val)
		} else {
			this.min = append(this.min, min)
		}
	}
	this.length++
}


func (this *MinStack) Pop()  {
    this.length--
    this.min = this.min[:this.length]
    this.elements = this.elements[:this.length]
}


func (this *MinStack) Top() int {
    return this.elements[this.length - 1]
}


func (this *MinStack) GetMin() int {
    return this.min[this.length-1]
}