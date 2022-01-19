package com.zensar.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${xmlorder.rabbitmq.queue}")
	String xmlqueueName;

	@Value("${xmlorder.rabbitmq.exchange}")
	String xmlexchange;

	@Value("${xmlorder.rabbitmq.routingkey}")
	private String xmlroutingkey;
	
	@Value("${jsonorder.rabbitmq.queue}")
	String queueName;

	@Value("${jsonorder.rabbitmq.exchange}")
	String exchange;

	@Value("${jsonorder.rabbitmq.routingkey}")
	private String routingkey;
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	Queue xmlqueue() {
		return new Queue(xmlqueueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	DirectExchange xmlexchange() {
		return new DirectExchange(xmlexchange);
	}

	@Bean
	Binding binding(@Qualifier("queue") Queue queue, @Qualifier("exchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}
	
	@Bean
	Binding xmlbinding(@Qualifier("xmlqueue") Queue queue, @Qualifier("xmlexchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(xmlroutingkey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	
	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		rabbitTemplate.setDefaultReceiveQueue(queue().getName());
		rabbitTemplate.setRoutingKey(routingkey);
		System.out.println("AmqpTemplate:" + rabbitTemplate.getExchange() );

		return rabbitTemplate;
	}
	
	@Bean
	public AmqpTemplate xmlrabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2XmlMessageConverter());
		rabbitTemplate.setDefaultReceiveQueue(xmlqueue().getName());
		rabbitTemplate.setRoutingKey(xmlroutingkey);
		System.out.println("AmqpTemplate:" + rabbitTemplate.getExchange() );

		return rabbitTemplate;
	}
	
}
