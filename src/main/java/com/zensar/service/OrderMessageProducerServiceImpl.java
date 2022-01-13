package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.JsonOrderDto;
import com.zensar.dto.XmlOrderDto;
import com.zensar.rabbitq.RabbitMQSender;
import com.zensar.rabbitq.RabbitMQXmlSender;

@Service
public class OrderMessageProducerServiceImpl implements OrderMessageProducerService {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@Autowired
	RabbitMQXmlSender rabbitMQXmlSender;
	
	@Override
	public String produceNewJsonOrder(JsonOrderDto jsonOrder) {
		
		rabbitMQSender.send(jsonOrder);
		return "Message sent to the RabbitMQ Successfully";
	}

	@Override
	public String produceNewXmlOrder(XmlOrderDto xmlOrder) {
		rabbitMQXmlSender.sendXmlMessage(xmlOrder);
		return "Xml Message sent to the RabbitMQ Successfully";
	}
	

}
