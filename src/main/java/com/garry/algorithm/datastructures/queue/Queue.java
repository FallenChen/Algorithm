package com.garry.algorithm.datastructures.queue;

public interface Queue<T> {

    void offer(T elem);

    T poll();

    T peek();

    int size();

    boolean isEmpty();
    
}
