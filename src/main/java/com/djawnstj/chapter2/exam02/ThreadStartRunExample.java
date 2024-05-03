package com.djawnstj.chapter2.exam02;

public class ThreadStartRunExample {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "스레드 실행 중..");
            }
        });

        thread.start();
    }

}
