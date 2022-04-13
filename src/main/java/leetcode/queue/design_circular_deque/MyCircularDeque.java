package leetcode.queue.design_circular_deque;

/**
 * @author cy
 * @className MyCircularDeque
 * @description TODO
 * @date 2021/8/7 17:50
 */
public class MyCircularDeque {

    /**
     * Design your implementation of the circular double-ended queue (deque).
     *
     * Implement the MyCircularDeque class:
     *
     *     {@link #MyCircularDeque(int k)} Initializes the deque with a maximum size of k.
     *     boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
     *     boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
     *     boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
     *     boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
     *     int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
     *     int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
     *     boolean isEmpty() Returns true if the deque is empty, or false otherwise.
     *     boolean isFull() Returns true if the deque is full, or false otherwise.
     */

    // ring buffer no edge cases
    int front = 0, rear = -1, len = 0, k = 0;
    int[] arr;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
        this.k = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
        {
            return false;
        }
        front = --front % k;
        if(front < 0)
        {
            front += k;
        }
        arr[front] = value;
        len++;
        if(len == 1)
        {
            rear = front;
        }
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
        {
            return false;
        }
        rear = ++rear % k;
        arr[rear] = value;
        len++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
        {
            return false;
        }
        front = ++front % k;
        len--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
        {
            return false;
        }
        rear = --rear % k;
        if(rear < 0)
        {
            rear += k;
        }
        len--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == k;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

