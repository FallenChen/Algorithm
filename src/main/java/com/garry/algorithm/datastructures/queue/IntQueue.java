package com.garry.algorithm.datastructures.queue;

/**
 * 实现了只有int的queue，无比的快和轻量
 * 性能是{@link java.util.ArrayDeque}的40+
 * 然而，缺点是，在queue工作的任何时刻，你都需要知道在队列里元素的上限，
 */
public class IntQueue implements Queue<Integer>{


    private int[] data;
    private int front, end;
    private int size;

    /**
     * maxSize is the maximum number of items
     * that can be in the queue at any time
     * @param maxSize
     */
    public IntQueue(int maxSize) {
        front = end = size = 0;
        data = new int[maxSize];
    }

    @Override
    public void offer(Integer elem) {
        if (isFull()){
            throw new RuntimeException("Queue too small");
        }
        data[end++] = elem;
        size++;
        end = end % data.length;
    }

    // todo 为什么不用 front和end 的差值来判断，还是说也可以
    private boolean isFull() {
        return size == data.length;
    }


    @Override
    public Integer poll() {
        if (size == 0){
            throw new RuntimeException("Queue is empty");
        }
        size--;
        front = front % data.length; // todo
        return data[front++];
    }

    @Override
    public Integer peek() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        front = front % data.length;
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
