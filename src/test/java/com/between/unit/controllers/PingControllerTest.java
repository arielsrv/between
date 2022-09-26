package com.between.unit.controllers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.between.controllers.PingController;
import org.junit.jupiter.api.Test;

public class PingControllerTest {

	@Test
	public void ping() {
		PingController pingController = new PingController();
		String actual = pingController.ping();

		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo("pong");
	}
}
