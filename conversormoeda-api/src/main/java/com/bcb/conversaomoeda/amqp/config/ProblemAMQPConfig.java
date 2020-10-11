package com.bcb.conversaomoeda.amqp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProblemAMQPConfig {

	public static final String EXCHANGE_NAME = "problems_tx";
    public static final String DEFAULT_QUEUE = "default_parser_q";
    public static final String ROUTING_KEY = "problems";

    @Bean
    public TopicExchange problemsExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue defaultParsingQueue() {
        return new Queue(DEFAULT_QUEUE);
    }

    @Bean
    public Binding queueToExchangeBinding() {
        return BindingBuilder.bind(defaultParsingQueue()).to(problemsExchange()).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
	
//	public static String EXCHANGE_NAME = "Problems";
//
//	@Bean
//	public Exchange declareExchange() {
//		return ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).build();
//	}
//	
//	@Bean
//	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//		return new MappingJackson2MessageConverter();
//	}
//
//	@Bean
//	public Jackson2JsonMessageConverter messageConverter() {
//		return new Jackson2JsonMessageConverter();
//	}

}
