package com.garry.algorithm.datastructures.queue;

/**
 * 
 */
public class ArrayQueue<T> implements Queue<T> {

    private Object[] data;
    private int front;
    private int rear;

    public ArrayQueue(int capacity){
        // ArrayQueue maximum size is data.length -1
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }



    @Override
    public void offer(T elem) {

        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        data[rear++] = elem;
        rear = adjustIndex(rear, data.length);

    }

    @Override
    public T poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
    


}
