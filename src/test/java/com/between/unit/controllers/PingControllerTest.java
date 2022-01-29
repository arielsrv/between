package com.between.unit.controllers;

import com.between.controllers.PingController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PingControllerTest {

    @Test
    public void ping() {
        PingController pingController = new PingController();
        String actual = pingController.pong();

        assertThat(actual).isEqualTo("pong");
    }
}
