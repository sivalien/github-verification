package com.example.githubclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MessageTemplateVerifierTest {

    @Test
    public void check() {
        String s1 = "LEETCODE-2021 Added solution for valid palindrome";
        String s2 = "ITERATOR-2021 Added LinkedList template solution";
        String s3 = "LEETCODE-2022 Changed merge interval solution";
        String s4 = "Added generator solution";
        String s5 = "LEETCODE Added insert interval solution";
        String s6 = "design-2021 youtube";
        String s7 = "LETCODE-2022 Added reorder list solution";
        String s8 = "LEETCODE-2021";
        String s9 = "LEETCODE-202 Added solution for palindromic substrings";
        String s10 = "Added solution for ITERATOR";

        assertTrue(MessageTemplateVerifier.check(s1));
        assertTrue(MessageTemplateVerifier.check(s2));
        assertTrue(MessageTemplateVerifier.check(s3));
        assertFalse(MessageTemplateVerifier.check(s4));
        assertFalse(MessageTemplateVerifier.check(s5));
        assertFalse(MessageTemplateVerifier.check(s6));
        assertFalse(MessageTemplateVerifier.check(s7));
        assertFalse(MessageTemplateVerifier.check(s8));
        assertFalse(MessageTemplateVerifier.check(s9));
        assertFalse(MessageTemplateVerifier.check(s10));
    }
}
