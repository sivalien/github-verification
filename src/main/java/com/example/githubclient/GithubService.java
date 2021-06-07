package com.example.githubclient;

import com.example.githubclient.model.databasemodels.RepoInfo;
import com.example.githubclient.model.githubmodels.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {
    private GithubClient client;
    private DatabaseService databaseService;

    public GithubService(GithubClient client) {
        this.client = client;
    }

    List<PullInfo> getPullInfo(String owner, String repo) throws IOException {
        return client.getUserRepoPulls(owner, repo).stream()
                .map(PullInfo::getTitle)
                .map(title -> title + "Hello")
                .map(title -> {PullInfo res = new PullInfo(); res.setTitle(title); return res;})
                .collect(Collectors.toList());
    }

    List<IssueComment> getIssueComments (String owner, String repo, int number) throws IOException {
        return client.getIssueComments(owner, repo, number).stream()
                .map(IssueComment::getBody)
                .map(comment -> "Issue comment: " + comment)
                .map(comment -> {IssueComment res = new IssueComment(); res.setBody(comment); return res;})
                .collect(Collectors.toList());
    }


    List<ReviewComment> getReviewComments (String owner, String repo, int number) throws IOException {
        return client.getReviewComments(owner, repo, number).stream()
                .map(ReviewComment::getBody)
                .map(comment -> "Review comment: " + comment)
                .map(comment -> {ReviewComment res = new ReviewComment(); res.setBody(comment); return res;})
                .collect(Collectors.toList());
    }

    List<CommitList> getCommits (String owner, String repo, int number) throws IOException {
        return client.getUserRepoCommits(owner, repo, number).stream()
                .map(commit -> "message: " + commit.getCommit().getMessage())
                .map(message -> {CommitList res = new CommitList(); Commit commit = new Commit(); commit.setMessage(message); res.setCommit(commit); return res;})
                .collect(Collectors.toList());
    }

    void checkPullAndCommit() throws IOException {
        List<RepoInfo> repoInfos = databaseService.getRepoInfo();
        for (RepoInfo repoInfo : repoInfos) {
            if (!repoInfo.isChecked()) {
                String owner = repoInfo.getLogin();
                String repo = repoInfo.getName();
                List<PullInfo> pullInfos = client.getUserRepoPulls(owner, repo);
                for (PullInfo pull: pullInfos) {
                    int number = pull.getNumber();
                    String message = MessageTemplateVerifier.process(pull, client.getUserRepoCommits(owner, repo, number));
                    IssueComment issueComment = new IssueComment();
                    ReviewComment reviewComment = new ReviewComment();
                    issueComment.setBody(message);
                    reviewComment.setBody(message);
                    client.createIssueComment(issueComment, repo, owner, number);
                    client.createReviewComment(reviewComment, repo, owner, number);
                }
            }
        }
    }
}
