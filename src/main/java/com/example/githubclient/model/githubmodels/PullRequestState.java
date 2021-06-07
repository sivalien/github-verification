package com.example.githubclient.model.githubmodels;

public enum PullRequestState {
    OPEN("open"),
    CLOSED("closed"),
    ALL("all");

    private final String value;

    PullRequestState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
