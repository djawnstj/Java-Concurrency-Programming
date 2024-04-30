package com.djawnstj.chapter1.exam01;

import java.util.ArrayList;
import java.util.List;

public class ParallelismExample {
    public static void main(String[] args) {

        final int cpuCores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU 개수: " + cpuCores + "개");

        // CPU 개수 만큼 데이터를 생성
        final List<Integer> data = new ArrayList<>();

        for (int i = 0; i < cpuCores; i++) {
            data.add(i);
        }

        // CPU 개수 만큼 데이터를 병렬 처리
        final long startTime1 = System.currentTimeMillis();

        final long sum1 = data.parallelStream()
                .mapToLong(it -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return it * it;
                }).sum();

        final long endTime1 = System.currentTimeMillis();

        System.out.println("CPU 개수 만큼 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime1 - startTime1) + "ms");
        System.out.println("결과1: " + sum1);

        // CPU 개수 만큼 데이터를 순차 처리
        final long startTime2 = System.currentTimeMillis();

        final long sum2 = data.stream()
                .mapToLong(it -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return it * it;
                }).sum();

        final long endTime2 = System.currentTimeMillis();

        System.out.println("CPU 개수 만큼 데이터를 순차로 처리하는 데 걸린 시간: " + (endTime2 - startTime2) + "ms");
        System.out.println("결과2: " + sum2);
    }
}
