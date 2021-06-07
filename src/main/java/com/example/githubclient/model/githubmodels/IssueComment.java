package com.example.githubclient.model.githubmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class IssueComment implements Serializable {
    @JsonProperty("body")
    private String body;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
