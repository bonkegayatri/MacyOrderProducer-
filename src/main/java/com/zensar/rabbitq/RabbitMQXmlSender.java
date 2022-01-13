package com.zensar.rabbitq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zensar.dto.XmlOrderDto;

@Service
public class RabbitMQXmlSender {

	@Autowired
	private AmqpTemplate xmlrabbitTemplate;
	
	@Value("${xmlorder.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${xmlorder.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void sendXmlMessage(XmlOrderDto xmlOrderDto) {
		xmlrabbitTemplate.convertAndSend(exchange, routingkey, xmlOrderDto);
		System.out.println("Send msg = " + xmlOrderDto);
	    
	}
	
}
