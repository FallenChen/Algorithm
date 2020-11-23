package com.garry.algorithm.datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public LinkedQueue() {}

    public LinkedQueue(T firstElem){
        offer(firstElem);
    }

    // add an element to the back of the queue
    @Override
    public void offer(T elem) {
        list.addLast(elem);
    }

    // poll an element from the front of the queue
    // the method throws an error if the queue is empty
    @Override
    public T poll() {
        if (isEmpty())
        {
            throw new RuntimeException("Queue Empty");
        }
        return list.removeFirst();
    }

    // peek the element at the front of the queue, not remove
    // the method throws an error id the queue is empty
    @Override
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // return an iterator to allow the user to traverse
    // through the elements found inside the queue
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
