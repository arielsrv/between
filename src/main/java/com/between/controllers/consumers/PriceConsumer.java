package com.between.controllers.consumers;

import com.between.entities.Product;
import com.between.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class PriceConsumer {

	RestHighLevelClient restHighLevelClient;
	ObjectMapper objectMapper;
	ProductRepository productRepository;

	@Autowired
	public PriceConsumer(
		RestHighLevelClient restHighLevelClient,
		ObjectMapper objectMapper,
		ProductRepository productRepository
	) {
		this.restHighLevelClient = restHighLevelClient;
		this.objectMapper = objectMapper;
		this.productRepository = productRepository;
	}

	@RabbitListener(queues = "products")
	public void listen(@Payload String id) throws IOException {

		Optional<Product> product = this.productRepository.getProduct(Integer.parseInt(id));

		if (product.isPresent()) {
			IndexRequest indexRequest = new IndexRequest("products");
			indexRequest.id(String.valueOf(product.get().id));
			indexRequest.source(objectMapper.writeValueAsString(product), XContentType.JSON);
			IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
			System.out.println("response id: " + indexResponse.getId());
		}

		System.out.println("Message read from myQueue : " + id);
	}
}