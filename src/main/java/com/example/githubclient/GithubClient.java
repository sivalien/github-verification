package com.example.githubclient;

import com.example.githubclient.model.CommitList;
import com.example.githubclient.model.IssueComment;
import com.example.githubclient.model.PullInfo;
import com.example.githubclient.model.ReviewComment;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.example.githubclient.MessageTemplateVerifier.process;


@Service
public class GithubClient {
    private String accessToken;
    private GithubApiInterface service;
    String API_BASE_URL = "https://api.github.com/";
    String API_VERSION_SPEC = "application/vnd.github.v3+json";
    String JSON_CONTENT_TYPE = "application/json";

    public GithubClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GithubApiInterface.class);
        this.accessToken = "token ";
        //this.accessToken = "token " + System.getenv("ACCESS_TOKEN");
    }

    public List<PullInfo> getUserRepoPulls(String owner, String repoName) throws IOException {
        Call<List<PullInfo>> retrofitCall = service.getUserPulls(accessToken, API_VERSION_SPEC, owner, repoName);
        Response<List<PullInfo>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }
    public List<CommitList> getUserRepoCommits(String owner, String repoName, int number) throws IOException {
        Call<List<CommitList>> retrofitCall = service.getUsersCommits(accessToken, API_VERSION_SPEC, owner, repoName, number);
        Response<List<CommitList>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public List<IssueComment> getIssueComments (String owner, String repoName, int number) throws IOException {
        Call<List<IssueComment>> retrofitCall = service.getIssueComments(accessToken, API_VERSION_SPEC, owner, repoName, number);
        Response<List<IssueComment>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public List<ReviewComment> getReviewComments (String owner, String repoName, int number) throws IOException {
        Call<List<ReviewComment>> retrofitCall = service.getReviewComments(accessToken, API_VERSION_SPEC, owner, repoName, number);
        Response<List<ReviewComment>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }
    public ReviewComment createReviewComment (ReviewComment reviewComment, String owner, String repoName, int number) throws IOException {
        Call<ReviewComment> retrofitCall = service.createReviewComment(reviewComment, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE, owner, repoName, number);

        Response<ReviewComment> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public IssueComment createIssueComment (IssueComment issueComment, String owner, String repoName, int number) throws IOException {
        Call<IssueComment> retrofitCall = service.createIssueComment(issueComment, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE, owner, repoName, number);

        Response<IssueComment> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }
}