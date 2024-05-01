package com.djawnstj.chapter2.exam01;

public class AnonymousThreadExample {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :스레드 실행 중..");
            }
        }.start();
    }
}
