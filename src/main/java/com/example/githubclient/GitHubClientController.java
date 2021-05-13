package com.example.githubclient;

import com.example.githubclient.model.CommitList;
import com.example.githubclient.model.IssueComment;
import com.example.githubclient.model.PullInfo;
import com.example.githubclient.model.ReviewComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GitHubClientController {
    @Autowired
    private GithubClient githubClient;

    @GetMapping("/repos/{owner}/{repo}/pulls")
    public List<PullInfo> getUserPulls (
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName) throws IOException {
        return githubClient.getUserRepoPulls(owner, repoName);
    }

    @GetMapping("/repos/{owner}/{repo}/pulls/{number}/commits")
    public List<CommitList> getUsersCommits (
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName,
            @PathVariable("number") int number) throws IOException {
        return githubClient.getUserRepoCommits(owner, repoName, number);
    }

    @GetMapping("/repos/{owner}/{repo}/pulls/{number}/issue")
    public List<IssueComment> getIssueComments (
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName,
            @PathVariable("number") int number) throws IOException {
        return githubClient.getIssueComments(owner, repoName, number);
    }

    @GetMapping("/repos/{owner}/{repo}/pulls/{number}/comments")
    public List<ReviewComment> getReviewComments (
            @PathVariable("owner") String owner,
            @PathVariable("repo") String repoName,
            @PathVariable("number") int number) throws IOException {
        return githubClient.getReviewComments(owner, repoName, number);
    }

    @PostMapping("/repos/{owner}/{repo}/pulls/{number}/comments")
    public ReviewComment createReviewComment (@RequestBody ReviewComment reviewComment,
                                              @PathVariable("owner") String owner,
                                              @PathVariable("repo") String repoName,
                                              @PathVariable("number") int number) throws IOException {
        return githubClient.createReviewComment(reviewComment, owner, repoName, number);
    }

    @PostMapping("/repos/{owner}/{repo}/pulls/{number}/issuecomments")
    public IssueComment createIssueComment (@RequestBody IssueComment issueComment,
                                            @PathVariable("owner") String owner,
                                            @PathVariable("repo") String repoName,
                                            @PathVariable("number") int number) throws IOException {
        return githubClient.createIssueComment(issueComment, owner, repoName, number);
    }
}
