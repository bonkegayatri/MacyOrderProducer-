package com.zensar.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.JsonOrderDto;
import com.zensar.dto.XmlOrderDto;


public interface OrderMessageProducerService {

	public String produceNewJsonOrder(@RequestBody JsonOrderDto jsonOrder);
	public String produceNewXmlOrder(@RequestBody XmlOrderDto xmlOrder);

}
