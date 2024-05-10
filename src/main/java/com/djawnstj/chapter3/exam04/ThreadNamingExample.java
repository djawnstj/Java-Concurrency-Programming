package com.djawnstj.chapter3.exam04;

public class ThreadNamingExample {
    public static void main(String[] args) throws InterruptedException {
        final Thread myThread = new Thread(() -> {
            System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
        }, "myThread");

        myThread.start();

        final Thread yourThread = new Thread(() -> {
            System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
        });
        yourThread.setName("yourThread");
        yourThread.start();

        for (int i = 0; i < 5; i++) {
            final Thread defaultThread = new Thread(() -> {
                System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
            });
            defaultThread.start();
        }

        Thread.sleep(2000);

    }
}
