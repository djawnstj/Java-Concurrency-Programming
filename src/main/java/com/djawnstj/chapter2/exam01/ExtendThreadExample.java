package com.djawnstj.chapter2.exam01;

public class ExtendThreadExample {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :스레드 실행 중..");
    }
}
