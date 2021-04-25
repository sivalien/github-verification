package com.example.githubclient;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;



@Service
public class GithubClient {
    private String accessToken;
    private GithubApiInterface service;
    String API_BASE_URL = "https://api.github.com/";
    String API_VERSION_SPEC = "application/vnd.github.v3+json";
    String JSON_CONTENT_TYPE = "application/json";

}