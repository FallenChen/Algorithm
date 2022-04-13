package leetcode.stack.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cy
 * @className MyStack
 * @description
 * @date 2021/11/13 14:40
 */
public class MyStack {

    /**
     * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
     *
     * Implement the MyStack class:
     *
     *     void push(int x) Pushes element x to the top of the stack.
     *     int pop() Removes the element on the top of the stack and returns it.
     *     int top() Returns the element on the top of the stack.
     *     boolean empty() Returns true if the stack is empty, false otherwise.
     *
     * Notes:
     *
     *     You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
     *     Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
     *
     * Input
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * Output
     * [null, null, null, 2, 2, false]
     *
     * Explanation
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // return 2
     * myStack.pop(); // return 2
     * myStack.empty(); // return False
     */

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    Queue<Integer> que;

    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.add(x);
        for(int i=0; i< que.size()-1; i++)
        {
            que.add(que.poll());
        }
    }

    public int pop() {
        return que.remove();
    }

    public int top() {
        return que.peek();
    }

    public boolean empty() {
        return que.isEmpty();
    }
}
