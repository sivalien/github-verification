package com.example.githubclient;

import java.lang.reflect.Field;

public class MessageSender {
    public static void main(String[] args) throws NoSuchFieldException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Влад Котов, где ТЗ? Ты же обещал...git ");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
