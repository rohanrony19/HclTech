package com.springboot.jmsorderproducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsProducerConfig {

	@Bean
	  public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);   // send JSON as TextMessage
	    converter.setTypeIdPropertyName("_type");   // include _type header automatically
	;
	    return converter;
	  }
	 
	
	  @Bean
	  public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory,
	                                 MessageConverter messageConverter) {
	    JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
	    jmsTemplate.setMessageConverter(messageConverter);
	    jmsTemplate.setPubSubDomain(false); // queue (false) vs topic (true)
	 
	    return jmsTemplate;
	  }
}
