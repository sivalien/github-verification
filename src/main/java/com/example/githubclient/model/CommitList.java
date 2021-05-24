package com.example.githubclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CommitList implements Serializable {
    @JsonProperty("url")
    private String url;
    @JsonProperty("commit")
    private Commit commit;

    public String getCommentsUrl() {
        return url;
    }

    public void url(String commentsUrl) {
        this.url = url;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}
