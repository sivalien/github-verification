package com.example.githubclient;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageSender {
    private GithubService service;

    @Scheduled(cron = "0/5 * * ? * *")
    void sendMessage() {
        System.out.println("Влад Котов, где ТЗ? Ты же обещал...");
    }

    @Scheduled(cron = "*/10 * * ? * *")
    public void check() throws IOException {
        service.checkPullAndCommit();
    }
}