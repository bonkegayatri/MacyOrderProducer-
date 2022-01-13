package com.zensar.rabbitq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zensar.dto.JsonOrderDto;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${jsonorder.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsonorder.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(JsonOrderDto jsonOrderDto) {
		rabbitTemplate.convertAndSend(exchange, routingkey, jsonOrderDto);
		System.out.println("Send msg = " + jsonOrderDto);
	    
	}
	
}
