package com.garry.algorithm.datastructures.queue;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private List<Queue<Integer>> queues = new ArrayList<>();

    @Before
    public void setup(){
        queues.add(new ArrayQueue<>(2));
    }

    @Test
    public void testEmptyQueue(){
        for(Queue queue : queues){
            assertThat(queue.isEmpty()).isTrue();
        }
    }
    
}
