package com.between.controllers.topics;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceTopic {

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public PriceTopic(
		RabbitTemplate rabbitTemplate
	) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(String productId) {
		rabbitTemplate.convertAndSend("products.topic", "products-feed", productId);
	}
}
