package com.djawnstj.chapter2.exam01;

public class ImplementRunnableExample {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}

class MyRunnable implements Runnable {
     @Override
    public void run() {
         System.out.println(Thread.currentThread().getName() + " :스레드 실행 중..");
    }
}
