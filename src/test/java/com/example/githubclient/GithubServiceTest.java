package com.example.githubclient;

import com.example.githubclient.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class GithubServiceTest extends AbstractGithubVerificationTest {
    GithubClient mock;
    GithubService service;
    String owner = "sivalien";
    String repo = "java_au";
    int number = 10;

    @Before
    public void init() {
        mock = Mockito.mock(GithubClient.class, Mockito.RETURNS_DEEP_STUBS);
        service = new GithubService(mock);
    }

    @Test
    public void testGetPullTitle() throws IOException {
        PullInfo pullInfo = new PullInfo();
        pullInfo.setTitle("Title ");
        Mockito.when(mock.getUserRepoPulls("sivalien", "java_au")).thenReturn(Collections.singletonList(pullInfo));
        List<PullInfo> pullInfoList = service.getPullInfo("sivalien", "java_au");
        assertEquals("Title Hello", pullInfoList.get(0).getTitle());
    }

    @Test
    public void testGetIssueComment() throws IOException {
        IssueComment issueComment = new IssueComment();
        issueComment.setBody("hello!!!");
        Mockito.when(mock.getIssueComments(owner, repo, number)).thenReturn(Collections.singletonList(issueComment));
        List<IssueComment> issueComments = service.getIssueComments(owner, repo, number);
        assertEquals("Issue comment: hello!!!", issueComments.get(0).getBody());
    }

    @Test
    public void testGetReviewComment() throws IOException {
        ReviewComment reviewComment = new ReviewComment();
        reviewComment.setBody("hello!!!");
        Mockito.when(mock.getReviewComments(owner, repo, number)).thenReturn(Collections.singletonList(reviewComment));
        List<ReviewComment> reviewComments = service.getReviewComments(owner, repo, number);
        assertEquals("Review comment: hello!!!", reviewComments.get(0).getBody());
    }

    @Test
    public void testGetCommit() throws IOException {
        CommitList commitList = new CommitList();
        Commit commit = new Commit();
        commit.setMessage("test");
        commitList.setCommit(commit);
        Mockito.when(mock.getUserRepoCommits(owner, repo, number)).thenReturn(Collections.singletonList(commitList));
        List<CommitList> commitLists = service.getCommits(owner, repo, number);
        assertEquals("message: test", commitLists.get(0).getCommit().getMessage());
    }
}
