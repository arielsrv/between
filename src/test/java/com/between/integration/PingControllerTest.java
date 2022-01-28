package com.between.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PingControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String apiUrl;

    @BeforeEach
    public void setUp() {
        this.apiUrl = String.format("http://localhost:%d", port);
    }

    @Test
    public void ping() {
        String url = this.apiUrl + "/ping";
        String actual = this.testRestTemplate.getForObject(url, String.class);

        assertThat(actual).isEqualTo("pong");
    }
}
