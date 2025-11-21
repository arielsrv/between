package com.between.integration.controllers;

import com.between.dtos.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

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
	@Tag("challenge")
	public void test_1() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-14T10:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
		// assertThat(actual.productId).isEqualTo(35455L);
		// assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(1L);
		assertThat(actual.price).isEqualTo("35.50");
		assertThat(actual.startDate).isEqualTo(LocalDateTime.parse("2020-06-14T00:00:00"));
		assertThat(actual.endDate).isEqualTo(LocalDateTime.parse("2020-12-31T23:59:59"));
	}

	@Test
	@Tag("challenge")
	public void test_2() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-14T16:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
		// assertThat(actual.productId).isEqualTo(35455L);
		// assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(2L);
		assertThat(actual.price).isEqualTo("25.45");
		assertThat(actual.startDate).isEqualTo(LocalDateTime.parse("2020-06-14T15:00:00"));
		assertThat(actual.endDate).isEqualTo(LocalDateTime.parse("2020-06-14T18:30:00"));
	}

	@Test
	@Tag("challenge")
	public void test_3() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-14T21:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
		// assertThat(actual.productId).isEqualTo(35455L);
		// assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(1L);
		assertThat(actual.price).isEqualTo("35.50");
		assertThat(actual.startDate).isEqualTo(LocalDateTime.parse("2020-06-14T00:00:00"));
		assertThat(actual.endDate).isEqualTo(LocalDateTime.parse("2020-12-31T23:59:59"));
	}

	@Test
	@Tag("challenge")
	public void test_4() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-15T10:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
		// assertThat(actual.productId).isEqualTo(35455L);
		// assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(3L);
		assertThat(actual.price).isEqualTo("30.50");
		assertThat(actual.startDate).isEqualTo(LocalDateTime.parse("2020-06-15T00:00:00"));
		assertThat(actual.endDate).isEqualTo(LocalDateTime.parse("2020-06-15T11:00:00"));
	}

	@Test
	@Tag("challenge")
	public void test_5() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-16T21:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
		// assertThat(actual.productId).isEqualTo(35455L);
		// assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(4L);
		assertThat(actual.price).isEqualTo("38.95");
		assertThat(actual.startDate).isEqualTo(LocalDateTime.parse("2020-06-15T16:00:00"));
		assertThat(actual.endDate).isEqualTo(LocalDateTime.parse("2020-12-31T23:59:59"));
	}

	@Test
	public void test_product_not_found() {
		String url = "/prices/search?product_id=1&application_date=2020-06-16T21:00:00&brand_id=1";
		try {
			this.restClient.get().uri(url).retrieve().toEntity(LinkedHashMap.class);
			// Si no lanza excepción, el test debe fallar
			throw new AssertionError("Se esperaba HTTP 404, pero la solicitud fue exitosa");
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			assertThat(e.getStatusCode().value()).isEqualTo(404);
		}
	}

	@Test
	public void test_brand_not_found() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-16T21:00:00&brand_id=5";
		try {
			this.restClient.get().uri(url).retrieve().toEntity(LinkedHashMap.class);
			throw new AssertionError("Se esperaba HTTP 404, pero la solicitud fue exitosa");
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			assertThat(e.getStatusCode().value()).isEqualTo(404);
		}
	}

	@Test
	public void test_price_not_found() {
		String url = "/prices/search?product_id=35455&application_date=2022-06-16T21:00:00&brand_id=1";
		try {
			this.restClient.get().uri(url).retrieve().toEntity(LinkedHashMap.class);
			throw new AssertionError("Se esperaba HTTP 404, pero la solicitud fue exitosa");
		} catch (org.springframework.web.client.HttpClientErrorException e) {
			assertThat(e.getStatusCode().value()).isEqualTo(404);
		}
	}

	@Test
	public void get_foo() {
		String url = "/prices/search?product_id=35455&application_date=2020-06-16T21:00:00&brand_id=1";
		PriceDto actual = this.restClient.get().uri(url).retrieve().body(PriceDto.class);

		assertThat(actual).isNotNull();
	}
}
