package com.example.githubclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commit {
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
