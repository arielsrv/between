package com.between.integration.controllers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PingControllerTest {

	@LocalServerPort
	private int port;

 private RestClient restClient;
 private String apiUrl;

	@BeforeEach
 public void setUp() {
        this.apiUrl = String.format("http://localhost:%d", port);
        this.restClient = RestClient.builder().baseUrl(this.apiUrl).build();
    }

	@Test
    public void ping() {
        String actual = this.restClient.get()
                .uri("/ping")
                .retrieve()
                .body(String.class);

        assertThat(actual).isEqualTo("pong");
    }
}
