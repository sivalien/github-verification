package com.example.githubclient;

public class MessageTemplateVerifier {
    private static final String PATTERN = "^((LEETCODE|ITERATOR|DESIGN|GENERATOR|TRIANGLE)-(2021|2022)).+";
    private static final String OK_RESULT = "OK!";
    private static final String NOT_OK_RESULT = "title should start with GENERATOR, LEETCODE, DESIGN, ITERATOR OR TRIANGLE," +
            "group number should be 2021 or 2022";

    static boolean check(String message) {
        return message.matches(PATTERN);
    }

    static String process (String message) {
        if (check(message)) {
            return OK_RESULT;
        }
        return NOT_OK_RESULT;
    }
}
