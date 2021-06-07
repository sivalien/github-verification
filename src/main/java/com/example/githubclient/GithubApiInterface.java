package com.example.githubclient;


import com.example.githubclient.model.CommitList;
import com.example.githubclient.model.IssueComment;
import com.example.githubclient.model.PullInfo;
import com.example.githubclient.model.ReviewComment;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GithubApiInterface {
    @GET("repos/{owner}/{repo}/pulls")
    Call<List<PullInfo>> getUserPulls (@Header("Authorization") String accessToken,
                                       @Header("Accept") String apiVersionSpec,
                                       @Path("owner") String owner,
                                       @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/pulls/{number}/commits")
    Call<List<CommitList>> getUsersCommits (@Header("Authorization") String accessToken,
                                            @Header("Accept") String apiVersionSpec,
                                            @Path("owner") String owner,
                                            @Path("repo") String repo,
                                            @Path("number") int number);
    @GET("repos/{owner}/{repo}/pulls/{number}/issue")
    Call<List<IssueComment>> getIssueComments (@Header("Authorization") String accessToken,
                                               @Header("Accept") String apiVersionSpec,
                                               @Path("owner") String owner,
                                               @Path("repo") String repo,
                                               @Path("number") int number);
    @GET("repos/{owner}/{repo}/pulls/{number}/comments")
    Call<List<ReviewComment>> getReviewComments (@Header("Authorization") String accessToken,
                                                 @Header("Accept") String apiVersionSpec,
                                                 @Path("owner") String owner,
                                                 @Path("repo") String repo,
                                                 @Path("number") int number);
    @POST("repos/{owner}/{repo}/pulls/{number}/comments")
    Call<ReviewComment> createReviewComment (@Body ReviewComment reviewComment,
                                             @Header("Authorization") String accessToken,
                                             @Header("Accept") String apiVersionSpec,
                                             @Header("Content-Type") String contentType,
                                             @Path("owner") String owner,
                                             @Path("repo") String repo,
                                             @Path("number") int number);

    @POST("repos/{owner}/{repo}/pulls/{number}/comments")
    Call<IssueComment> createIssueComment (@Body IssueComment issueComment,
                                           @Header("Authorization") String accessToken,
                                           @Header("Accept") String apiVersionSpec,
                                           @Header("Content-Type") String contentType,
                                           @Path("owner") String owner,
                                           @Path("repo") String repo,
                                           @Path("number") int number);

}