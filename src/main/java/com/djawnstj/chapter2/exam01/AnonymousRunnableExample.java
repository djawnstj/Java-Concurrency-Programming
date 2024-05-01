package com.djawnstj.chapter2.exam01;

public class AnonymousRunnableExample {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :스레드 실행 중..");
            }
        }).start();
    }
}
