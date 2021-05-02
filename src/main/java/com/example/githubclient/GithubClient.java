package com.example.githubclient;

import org.springframework.stereotype.Service;


@Service
public class GithubClient {
    private String accessToken;
    private GithubApiInterface service;
    String API_BASE_URL = "https://api.github.com/";
    String API_VERSION_SPEC = "application/vnd.github.v3+json";
    String JSON_CONTENT_TYPE = "application/json";

}