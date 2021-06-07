package com.example.githubclient.model.githubmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Commit implements Serializable {
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
