package com.djawnstj.chapter1.exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CPUBoundExample {
    public static void main(String[] args) {
        final int numThreads = Runtime.getRuntime().availableProcessors();
        final ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        final long startTime = System.currentTimeMillis();
        final List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final Future<?> future = executorService.submit(() -> {

                // CPU 연산이 집중되고 오래 걸리는 작업
                long result = 0L;
                for (long j = 0; j < 1000000000L; j++) {
                    result += j;
                }

                // 아주 잠깐 대기함
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("스레드: " + Thread.currentThread().getName() + ", " + result); // CPU Bound 일때 ContextSwitching
            });

            futures.add(future);
        }

        futures.forEach(it -> {
            try {
                it.get();
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        final long endTime = System.currentTimeMillis();
        System.out.println("CPI 개수를 초과하는 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime - startTime) + "ms");
        executorService.shutdown();
    }
}
