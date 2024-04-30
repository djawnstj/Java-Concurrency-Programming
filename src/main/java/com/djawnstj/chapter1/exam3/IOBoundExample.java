package com.djawnstj.chapter1.exam3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundExample {
    public static void main(String[] args) {
        final int numThreads = Runtime.getRuntime().availableProcessors() * 2;
        final ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        final Path resourcesPath = Paths.get("src", "main", "java", "com", "djawnstj", "chapter1", "exam3", "io-bound-file.txt");

        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                try {
                    // IO 가 집중 되는 작업
                    for (int j = 0; j < 5; j++) {
                        Files.readAllLines(resourcesPath);
                        System.out.println("스레드: " + Thread.currentThread().getName() + ", " + j); // IO Bound 일 때 ContextSwitching
                    }

                    // 아주 빠른 Cpu 연산
                    int result = 0;
                    for (int j = 0; j < 10; j++) {
                        result += j;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
