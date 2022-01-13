package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.JsonOrderDto;
import com.zensar.dto.XmlOrderDto;
import com.zensar.service.OrderMessageProducerService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("produce")
public class OrderMessageProducerController {

	@Autowired
	private OrderMessageProducerService orderMessageProducerService;
	
	@PostMapping(value = "/jsonorder", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Produce Json Order",httpMethod = "POST")
	public String produceNewJsonOrder(@RequestBody JsonOrderDto jsonOrder) {
	    return orderMessageProducerService.produceNewJsonOrder(jsonOrder);
	}
	
	@PostMapping(value = "/xmlorder", consumes = MediaType.APPLICATION_XML_VALUE)
	@ApiOperation(value = "Produce Xml Order",httpMethod = "POST")
	public String produceNewXmlOrder(@RequestBody XmlOrderDto xmlOrder) {
	    return orderMessageProducerService.produceNewXmlOrder(xmlOrder);
	}
	
}
