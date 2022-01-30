package com.between.integration.controllers;

import com.between.dtos.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

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
	public void test_1() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-14T10:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
		assertThat(actual.productId).isEqualTo(35455L);
		assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(1L);
		assertThat(actual.price).isEqualTo("35.50");
	}

	@Test
	public void test_2() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-14T16:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
		assertThat(actual.productId).isEqualTo(35455L);
		assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(2L);
		assertThat(actual.price).isEqualTo("25.45");
	}

	@Test
	public void test_3() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-14T21:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
		assertThat(actual.productId).isEqualTo(35455L);
		assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(1L);
		assertThat(actual.price).isEqualTo("35.50");
	}

	@Test
	public void test_4() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-15T10:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
		assertThat(actual.productId).isEqualTo(35455L);
		assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(3L);
		assertThat(actual.price).isEqualTo("30.50");
	}

	@Test
	public void test_5() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-16T21:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
		assertThat(actual.productId).isEqualTo(35455L);
		assertThat(actual.brandId).isEqualTo(1L);
		assertThat(actual.priceList).isEqualTo(4L);
		assertThat(actual.price).isEqualTo("38.95");
	}

	@Test
	public void test_product_not_found() {
		String url = this.apiUrl + "/prices/1?application_date=2020-06-16T21:00:00&brand_id=1";
		LinkedHashMap<String, Object> actual = this.testRestTemplate.getForObject(url, LinkedHashMap.class);

		assertThat(actual).isNotNull();
		assertThat(actual.get("status")).isEqualTo(400);
	}

	@Test
	public void test_price_not_found() {
		String url = this.apiUrl + "/prices/35455?application_date=2022-06-16T21:00:00&brand_id=1";
		LinkedHashMap<String, Object> actual = this.testRestTemplate.getForObject(url, LinkedHashMap.class);

		assertThat(actual).isNotNull();
		assertThat(actual.get("status")).isEqualTo(404);
	}


	@Test
	public void get_foo() {
		String url = this.apiUrl + "/prices/35455?application_date=2020-06-16T21:00:00&brand_id=1";
		PriceDto actual = this.testRestTemplate.getForObject(url, PriceDto.class);

		assertThat(actual).isNotNull();
	}
}
