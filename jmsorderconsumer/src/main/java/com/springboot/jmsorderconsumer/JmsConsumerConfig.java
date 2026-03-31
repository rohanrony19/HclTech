package com.springboot.jmsorderconsumer;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConsumerConfig {

	@Bean
	  public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);   // expect TEXT
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	  }
	 
	  @Bean
	  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
	      ConnectionFactory connectionFactory, MessageConverter messageConverter) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory);
	    factory.setMessageConverter(messageConverter);
	    factory.setPubSubDomain(false);
	    return factory;
	  }
}
