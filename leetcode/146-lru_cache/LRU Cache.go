package leetcode

type LRUCache struct {
	Capacity 	int
	Keys 		map[int]*Node
	// head is the most recently used node
	// tail is the least recently used node
	head, tail 	*Node
}

type Node struct {
	Key, Value	int
	// doubly linked list
	Prev, Next	*Node
}


func Constructor(capacity int) LRUCache {
    return LRUCache{
	    Keys: 	make(map[int]*Node),
	    Capacity: 	capacity,
    }
}


func (this *LRUCache) Get(key int) int {
    if node, ok := this.Keys[key]; ok {
	    this.Remove(node) // remove from current position
	    this.Add(node) // add to head
	    return node.Value
    }

    return -1
}


func (this *LRUCache) Put(key int, value int)  {
    if node, ok := this.Keys[key]; ok {
	    node.Value = value
	    this.Remove(node)
	    this.Add(node)
	    return
    }else {
	    node := &Node{ Key: key, Value: value }
	    this.Keys[key] = node
	    this.Add(node)
    }

    if len(this.Keys) > this.Capacity {
	    delete(this.Keys, this.tail.Key)
	    this.Remove(this.tail)
    }
}


func (this *LRUCache) Add(node *Node) {
	node.Next = this.head
	node.Prev = nil
	if this.head != nil {
		this.head.Prev = node
	}

	this.head = node

	if this.tail == nil {
		this.tail = node
		this.tail.Next = nil
	}
}

func (this *LRUCache) Remove(node *Node) {
	if node == this.head {
		this.head = node.Next
		node.Next = nil
		return
	}
	if node == this.tail {
		this.tail = node.Prev
		node.Prev.Next = nil
		node.Prev = nil
		return
	}
	// remove node in LinkedList
	node.Prev.Next = node.Next
	node.Next.Prev = node.Prev
}

