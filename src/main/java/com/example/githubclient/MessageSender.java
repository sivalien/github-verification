package com.example.githubclient;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Scheduled(cron = "0/5 * * ? * *")
    void sendMessage() {
        System.out.println("Влад Котов, где ТЗ? Ты же обещал...");
    }
}