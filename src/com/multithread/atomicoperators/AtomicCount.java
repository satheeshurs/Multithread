package com.multithread.atomicoperators;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCount {

   // private AtomicInteger counter = new AtomicInteger();
    private volatile int counter;

    public int getCounter() {
        return counter;
    }

    public int incrementCounter() {
       return counter++;
    }
}
