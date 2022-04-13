package leetcode.linked_list.design_linked_list;

public class MyLinkedList {

	int size;
	// dummy node
	ListNode head;
	
	public MyLinkedList() {
		size = 0;
		head = new ListNode(0);
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("index is illegal");
		}
		ListNode cur = head;
		for (int i = 0; i <= index; i++) {
			cur = cur.next;
		}
		return cur.val;
	}
	
	public void addAtHead(int val) {
	    addAtIndex(0, val);
	}
	
	public void addAtTail(int val) {
	    addAtIndex(size,val);
	}
	
	public void addAtIndex(int index, int val) {
	    if(index > size)
	    {
		    return;
	    }
	    if(index < 0)
	    {
		    index = 0;
	    }
	    size++;
	    ListNode prev = head;
	    for(int i=0; i<index; i++)
	    {
		    prev = prev.next;
	    }
	    ListNode toAdd = new ListNode(val);
	    toAdd.next = prev.next;
	    prev.next = toAdd;
	}
	
	public void deleteAtIndex(int index) {
	   if(index < 0 || index >= size)
	   {
		   return;
	   }
	   size--;
	   ListNode prev = head;
	   for (int i=0; i<index; i++)
	   {
		   prev = prev.next;
	   }
	   prev.next = prev.next.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode()
	{

	}
	ListNode(int x) { val = x; }
}
