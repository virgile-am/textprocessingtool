 package com.example.textprocessingtool.e2e;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TextProcessingE2ETest {

    @LocalServerPort
    private int port;

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testProcessText() {
        String url = "http://localhost:" + port + "/text/processText";
        String text = "apple banana apple";
        String regex = "apple";
        String response = restTemplate.postForObject(url + "?text=" + text + "&regex=" + regex, null, String.class);
        assertEquals("apple apple", response);
    }

    // Similar tests for other endpoints can be added here
}
