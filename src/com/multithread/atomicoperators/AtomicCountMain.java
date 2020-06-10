package com.multithread.atomicoperators;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicCountMain {

    public static void main(String[] args) {
        try {
            System.out.println(LocalTime.now());
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            AtomicCount atomicCount = new AtomicCount();
            executorService.submit(()->{
                for(int i=1;i<=20000;i++){
                    atomicCount.incrementCounter();
                }
                System.out.println(LocalTime.now());
            });
            executorService.submit(()->{
                for(int i=1;i<=80000;i++){
                    atomicCount.incrementCounter();
                }
                System.out.println(LocalTime.now());
            });

            executorService.awaitTermination(3, TimeUnit.SECONDS);
            executorService.shutdown();

            System.out.println("Count : " + atomicCount.getCounter());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
