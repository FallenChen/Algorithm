package com.garry.algorithm.datastructures.queue;

/**
 * 除了泛型，size属性的缺失是ArrayQueue和IntQueue的另一个区别。ArrayQueue的size，是由公式，根据空状态和满状态计算出
 * 
 * ArrayQueue最大的size是data.length-1。如果吧数组看成圆形，那么从逻辑上讲，变量 rear的位置总是在变量 front的前面。
 * 所以，rear和front 之间组成的状态数，就是data array的长度
 * 而，所有的状态中的一个，用来判断queue是空还是满
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
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        front = adjustIndex(front, data.length);
        return (T)data[front++];
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        front = adjustIndex(front, data.length);
        return (T)data[front];
    }

    
    // todo 不好想
    @Override
    public int size() {
                return adjustIndex(rear + data.length - front, data.length);
    }

    private int adjustIndex(int index, int size){
        return index >= size ? index - size : index;
    }

    @Override
    public boolean isEmpty() {
        // 想象成圆形
        return rear == front;
    }
    // 满的时候，就是rear刚好在front前面 所以下面其实是 1 % data.length
    public boolean isFull(){
        return (front + data.length - rear) % data.length == 1;
    }


}
